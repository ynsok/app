package com.example.app.itemView

import android.view.View
import com.example.app.R
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

class EmployeeItemView(parent: Matcher<View>) :
    KRecyclerItem<EmployeeItemView>(parent) {

    val employeeName = KTextView(parent) { withId(R.id.employeeName) }
    val lastName = KTextView(parent) { withId(R.id.lastName) }
    val age = KTextView(parent) { withId(R.id.age) }
    val gender = KTextView(parent) { withId(R.id.gender) }
    val remove = KImageView(parent) { withId(R.id.remove) }
    val edit = KImageView(parent) { withId(R.id.edit) }
    val addAddress = KTextView(parent) { withId(R.id.addAddress) }
}
