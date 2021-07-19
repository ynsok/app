package com.example.app.ui.dialog

import android.app.Activity
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.app.R
import com.example.app.ui.entity.AddressItem
import com.example.app.ui.entity.EmployeeItem

fun Activity.openAddressEditDialog(
    addressItem: AddressItem? = null,
    onSaveButtonClick: (AddressItem) -> Unit
) =
    AddressEditDialog(
        this,
        R.style.DialogStyle,
        addressItem,
        onSaveButtonClick
    ).centerDialog().show()

fun Activity.openEmployeeEditDialog(
    employeeItem: EmployeeItem,
    onSaveButtonClick: (EmployeeItem) -> Unit
) =
    EmployeeEditDialog(
        this,
        R.style.DialogStyle,
        employeeItem,
        onSaveButtonClick
    ).centerDialog().show()

fun Activity.openAddEmployeeDialog(onSaveButtonClick: (EmployeeItem) -> Unit) =
    AddEmployeeDialog(
        this,
        R.style.DialogStyle,
        onSaveButtonClick
    ).centerDialog().show()

fun AlertDialog.centerDialog() = apply {
    window?.apply {
        setGravity(Gravity.CENTER)
        setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}
