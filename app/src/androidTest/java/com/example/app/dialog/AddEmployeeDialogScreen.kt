package com.example.app.dialog

import com.example.app.R
import com.example.app.ui.dialog.AddEmployeeDialog
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object AddEmployeeDialogScreen : KScreen<AddEmployeeDialogScreen>() {
    override val layoutId = R.layout.add_employee_dialog

    override val viewClass = AddEmployeeDialog::class.java

    val editText_employee_id = KEditText { withId(R.id.editText_employee_id) }
    val editText_firstName = KEditText { withId(R.id.editText_firstName) }
    val editText_lastName = KEditText { withId(R.id.editText_lastName) }
    val editText_age = KEditText { withId(R.id.editText_age) }
    val save_button = KButton { withId(R.id.save_button) }
}
