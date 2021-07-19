package com.example.app.itemView

import android.view.View
import com.example.app.R
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher

class AddEmployeeItemView(parent: Matcher<View>) :
    KRecyclerItem<AddEmployeeItemView>(parent) {

    val add_employee_button = KButton(parent) { withId(R.id.add_employee_button) }
}
