package com.example.app.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.app.R
import com.example.app.domain.entity.Gender
import com.example.app.ui.entity.EmployeeItem
import com.example.app.ui.extenstion.showShortToast
import kotlinx.android.synthetic.main.add_employee_dialog.*
import kotlinx.android.synthetic.main.add_employee_dialog.view.*

class AddEmployeeDialog(
    context: Context,
    themeResId: Int,
    private val onSaveEditButtonClick: (EmployeeItem) -> Unit
) : AlertDialog(context, themeResId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        with(LayoutInflater.from(context).inflate(R.layout.add_employee_dialog, null)) {
            spinner_gender.adapter = getSpinnerAdapter()
            save_button.setOnClickListener { saveButtonClick() }
            setView(this)
        }
        super.onCreate(savedInstanceState)
    }

    private fun getSpinnerAdapter(): ArrayAdapter<String> {
        val genders = listOf(Gender.MALE.name, Gender.FEMALE.name)
        val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, genders)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return adapter
    }

    private fun saveButtonClick() {
        val employeeId = editText_employee_id.text.toString()
        val firstName = editText_firstName.text.toString()
        val lastName = editText_lastName.text.toString()
        val age = editText_age.text.toString()

        if (isAnyFieldsEmpty(employeeId, firstName, lastName, age)) {
            context.showShortToast(R.string.fields_cant_be_empty)
        } else {
            invokeOnSaveEditButtonClick(employeeId.toLong())
            dismiss()
        }
    }

    private fun isAnyFieldsEmpty(
        employeeId: String,
        firstName: String,
        lastName: String,
        age: String
    ) = employeeId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || age.isEmpty()

    private fun invokeOnSaveEditButtonClick(employeeId: Long) = onSaveEditButtonClick.invoke(
        EmployeeItem(
            employeeId = employeeId,
            firstName = editText_firstName.text.toString(),
            lastName = editText_lastName.text.toString(),
            age = editText_age.text.toString().toLong(),
            gender = Gender.valueOf(spinner_gender.selectedItem.toString()),
            addressItem = emptyList()
        )
    )
}
