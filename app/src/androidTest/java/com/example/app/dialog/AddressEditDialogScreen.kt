package com.example.app.dialog

import com.example.app.R
import com.example.app.ui.dialog.AddressEditDialog
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object AddressEditDialogScreen : KScreen<AddressEditDialogScreen>() {
    override val layoutId = R.layout.address_dialog

    override val viewClass = AddressEditDialog::class.java

    val editText_home_number = KEditText { withId(R.id.editText_home_number) }
    val editText_city = KEditText { withId(R.id.editText_city) }
    val editText_street = KEditText { withId(R.id.editText_street) }
    val save_button = KButton { withId(R.id.save_button) }
}
