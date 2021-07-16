package com.example.app.domain.entity

data class Employee(
    val employeeId: Long,
    val firstName: String,
    val lastName: String,
    val age: Long,
    val gender: Gender,
    val address: List<Address>
)
