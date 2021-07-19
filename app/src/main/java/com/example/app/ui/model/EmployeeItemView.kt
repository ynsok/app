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

    var onCloseClick: (() -> Unit)? = null
        @CallbackProp set

    var onAddAddress: (() -> Unit)? = null
        @CallbackProp set

    init {
        inflate(context, R.layout.employee_item, this)

        edit.setOnClickListener { onEditClick?.invoke() }
        close.setOnClickListener { onCloseClick?.invoke() }
        addAddress.setOnClickListener { onAddAddress?.invoke() }
    }

    @ModelProp
    fun setEmployee(item: EmployeeItem) {
        employeeName.text = "Name: ${item.firstName}"
        lastName.text = "Last Name: ${item.lastName}"
        age.text = "Age: ${item.age}"
        gender.text = "Gender: ${item.gender}"
    }
}
