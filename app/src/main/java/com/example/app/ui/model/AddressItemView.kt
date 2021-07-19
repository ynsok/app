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

    var onRemoveClick: (() -> Unit)? = null
        @CallbackProp set

    init {
        inflate(context, R.layout.address_item, this)

        edit.setOnClickListener { onEditClick?.invoke() }
        remove.setOnClickListener { onRemoveClick?.invoke() }
    }

    @ModelProp
    fun setAddress(item: AddressItem) {
        homeNumber.text = context.getString(R.string.address_item_home_number) + item.homeNumber
        city.text = context.getString(R.string.address_item_city) + item.city
        street.text = context.getString(R.string.address_item_street) + item.street
    }

    @ModelProp
    fun setAddressIndex(index: Int) {
        separator.text = context.getString(R.string.address_item_address) + index
    }
}
