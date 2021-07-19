package com.example.app.ui.model

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.example.app.R
import kotlinx.android.synthetic.main.add_employee_item.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddEmployeeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var onAddEmployeeClick: (() -> Unit)? = null
        @CallbackProp set

    init {
        inflate(context, R.layout.add_employee_item, this)
        add_employee_button.setOnClickListener { onAddEmployeeClick?.invoke() }
    }
}
