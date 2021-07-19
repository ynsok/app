package com.example.app.dialog

import com.example.app.R
import com.example.app.ui.dialog.EmployeeEditDialog
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object EmployeeEditDialogScreen : KScreen<EmployeeEditDialogScreen>() {
    override val layoutId = R.layout.employee_dialog

    override val viewClass = EmployeeEditDialog::class.java

    val editText_firstName = KEditText { withId(R.id.editText_firstName) }
    val editText_lastName = KEditText { withId(R.id.editText_lastName) }
    val editText_age = KEditText { withId(R.id.editText_age) }
    val save = KButton { withId(R.id.save_button) }
}
