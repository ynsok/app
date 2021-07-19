package com.example.app.ui.model

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.example.app.R
import com.example.app.ui.entity.EmployeeItem
import kotlinx.android.synthetic.main.employee_item.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class EmployeeItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var onEditClick: (() -> Unit)? = null
        @CallbackProp set

    var onRemoveClick: (() -> Unit)? = null
        @CallbackProp set

    var onAddAddress: (() -> Unit)? = null
        @CallbackProp set

    init {
        inflate(context, R.layout.employee_item, this)

        edit.setOnClickListener { onEditClick?.invoke() }
        remove.setOnClickListener { onRemoveClick?.invoke() }
        addAddress.setOnClickListener { onAddAddress?.invoke() }
    }

    @ModelProp
    fun setEmployee(item: EmployeeItem) {
        separator.text = context.getString(R.string.employee_item_employee) + item.employeeId
        employeeName.text = context.getString(R.string.employee_item_name) + item.firstName
        lastName.text = context.getString(R.string.employee_item_last_name) + item.lastName
        age.text = context.getString(R.string.employee_item_age) + item.age
        gender.text = context.getString(R.string.employee_item_gender) + item.gender
    }
}
