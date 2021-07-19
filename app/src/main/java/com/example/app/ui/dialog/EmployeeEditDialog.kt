package com.example.app.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.app.R
import com.example.app.domain.entity.Gender
import com.example.app.ui.entity.EmployeeItem
import kotlinx.android.synthetic.main.employee_dialog.view.*

class EmployeeEditDialog(
    context: Context,
    themeResId: Int,
    private val employee: EmployeeItem,
    private val onSaveButtonClick: (EmployeeItem) -> Unit
) : AlertDialog(context, themeResId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        with(LayoutInflater.from(context).inflate(R.layout.employee_dialog, null)) {

            spinner_gender.adapter = getAdapter()
            with(employee) {
                editText_firstName.setText(firstName)
                editText_lastName.setText(lastName)
                editText_age.setText(age.toString())
            }
            save_button.setOnClickListener {
                onSaveButtonClick.invoke(
                    employee.copy(
                        firstName = editText_firstName.text.toString(),
                        lastName = editText_lastName.text.toString(),
                        age = editText_age.text.toString().toLong(),
                        gender = Gender.valueOf(spinner_gender.selectedItem.toString())
                    )
                )
                dismiss()
            }
            setView(this)
        }
        super.onCreate(savedInstanceState)
    }

    private fun getAdapter(): ArrayAdapter<String> {
        val genders = listOf(Gender.MALE.name, Gender.FEMALE.name)
        val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, genders)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return adapter
    }
}
