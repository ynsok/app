package com.example.app.itemView

import android.view.View
import com.example.app.R
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

class AddressItemView(parent: Matcher<View>) :
    KRecyclerItem<AddressItemView>(parent) {

    val homeNumber = KTextView(parent) { withId(R.id.homeNumber) }
    val city = KTextView(parent) { withId(R.id.city) }
    val street = KTextView(parent) { withId(R.id.street) }
    val remove = KTextView(parent) { withId(R.id.remove) }
    val editAddress = KImageView(parent) { withId(R.id.edit) }
}
