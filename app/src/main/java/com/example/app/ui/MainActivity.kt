package com.example.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import com.example.app.domain.entity.Gender
import com.example.app.ui.entity.AddressItem
import com.example.app.ui.entity.EmployeeItem
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: EmployeeViewModel by viewModel()
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainScope.launch {
            viewModel.getEmployees().collect {
                println(it)
            }
        }

        viewModel.saveEmployee(
            EmployeeItem(
                employeeId = 123,
                firstName = "Tobiasz",
                lastName = "Kansy",
                age = 21,
                gender = Gender.MALE,
                addressItem = listOf(
                    AddressItem(
                        street = "Krzywa",
                        city = "Kozlowice",
                        employeeId = 123,
                        homeNumber = 10
                    ),
                    AddressItem(
                        street = "Kozlowice",
                        city = "Dom",
                        employeeId = 123,
                        homeNumber = 12
                    )
                )
            )
        )
    }
}
