package com.example.app.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.app.R
import com.example.app.ui.entity.AddressItem
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
            address?.let { setupViews(it) }
            save_button.setOnClickListener { onSaveButtonClick() }
            setView(this)
        }

        super.onCreate(savedInstanceState)
    }

    private fun onSaveButtonClick() {
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

    private fun setupViews(address: AddressItem) = with(address) {
        editText_home_number.setText(homeNumber.toString())
        editText_city.setText(city)
        editText_street.setText(street)
    }
}
