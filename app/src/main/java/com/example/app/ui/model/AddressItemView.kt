package com.example.app.ui.model

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.example.app.R
import com.example.app.ui.entity.AddressItem
import kotlinx.android.synthetic.main.address_item.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddressItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var onEditClick: (() -> Unit)? = null
        @CallbackProp set

    var onCloseClick: (() -> Unit)? = null
        @CallbackProp set

    init {
        inflate(context, R.layout.address_item, this)

        edit.setOnClickListener { onEditClick?.invoke() }
        close.setOnClickListener { onCloseClick?.invoke() }
    }

    @ModelProp
    fun setAddress(item: AddressItem) {
        homeNumber.text = "Home Number: ${item.homeNumber}"
        city.text = "City: ${item.city}"
        street.text = "Street: ${item.street}"
    }
}
