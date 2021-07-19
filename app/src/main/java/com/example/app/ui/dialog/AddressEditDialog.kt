package com.example.app.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.app.R
import com.example.app.ui.entity.AddressItem
import com.example.app.ui.extensions.showShortToast
import kotlinx.android.synthetic.main.address_dialog.*
import kotlinx.android.synthetic.main.address_dialog.view.*

class AddressEditDialog(
    context: Context,
    themeResId: Int,
    private val address: AddressItem?,
    private val onSaveButtonClick: (AddressItem) -> Unit
) : AlertDialog(context, themeResId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        with(LayoutInflater.from(context).inflate(R.layout.address_dialog, null)) {
            address?.let {
                editText_home_number.setText(it.homeNumber.toString())
                editText_city.setText(it.city)
                editText_street.setText(it.street)
            }
            save_button.setOnClickListener { saveButtonClick() }
            setView(this)
        }

        super.onCreate(savedInstanceState)
    }

    private fun saveButtonClick() {
        val homeNumber = editText_home_number.text.toString()
        val city = editText_home_number.text.toString()
        val street = editText_street.text.toString()

        if (isAnyFieldsEmpty(homeNumber, city, street)) {
            context.showShortToast(R.string.fields_cant_be_empty)
        } else {
            invokeOnSaveButtonClick()
            dismiss()
        }
    }

    private fun isAnyFieldsEmpty(
        homeNumber: String,
        city: String,
        street: String
    ) = homeNumber.isEmpty() || city.isEmpty() || street.isEmpty()

    private fun invokeOnSaveButtonClick() {
        val address = address ?: AddressItem()
        onSaveButtonClick.invoke(
            address.copy(
                homeNumber = editText_home_number.text.toString().toLong(),
                city = editText_city.text.toString(),
                street = editText_street.text.toString()
            )
        )
        dismiss()
    }
}
