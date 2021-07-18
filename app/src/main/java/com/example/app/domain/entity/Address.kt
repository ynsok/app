package com.example.app.domain.entity

data class Address(
    val addressId: Long = 0,
    val employeeId: Long,
    val homeNumber: Long,
    val city: String,
    val street: String
)
