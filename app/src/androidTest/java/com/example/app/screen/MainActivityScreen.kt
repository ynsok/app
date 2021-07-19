package com.example.app.screen

import com.example.app.R
import com.example.app.itemView.AddEmployeeItemView
import com.example.app.itemView.AddressItemView
import com.example.app.itemView.EmployeeItemView
import com.example.app.ui.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView

object MainActivityScreen : KScreen<MainActivityScreen>() {
    override val layoutId: Int = R.layout.activity_main
    override val viewClass = MainActivity::class.java

    val employeeRecycler = KRecyclerView(
        { withId(R.id.employeeRecycler) },
        {
            itemType(::AddressItemView)
            itemType(::EmployeeItemView)
            itemType(::AddEmployeeItemView)
        }
    )
}
