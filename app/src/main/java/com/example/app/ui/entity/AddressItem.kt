package com.example.app.ui.entity

import com.example.app.domain.entity.Address

data class AddressItem(
    val employeeId: Long,
    val homeNumber: Long,
    val city: String,
    val street: String
)

fun Address.toItem() = AddressItem(employeeId, homeNumber, city, street)

fun AddressItem.toDomain() = Address(employeeId, homeNumber, city, street)

fun List<Address>.toItems() = map { it.toItem() }

fun List<AddressItem>.toDomains() = map { it.toDomain() }