package com.example.app.ui.entity

import com.example.app.domain.entity.Employee
import com.example.app.domain.entity.Gender

data class EmployeeItem(
    val employeeId: Long = 0,
    val firstName: String,
    val lastName: String,
    val age: Long,
    val gender: Gender,
    val addressItem: List<AddressItem>
)

fun Employee.toItem() =
    EmployeeItem(employeeId, firstName, lastName, age, gender, address.toItems())

fun List<Employee>.toItems() = map { it.toItem() }

fun EmployeeItem.toDomain() =
    Employee(employeeId, firstName, lastName, age, gender, addressItem.toDomains())
