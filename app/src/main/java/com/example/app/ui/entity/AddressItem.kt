package com.example.app.ui.entity

import com.example.app.domain.entity.Address

data class AddressItem(
    val addressId: Long = 0,
    val employeeId: Long = 0,
    val homeNumber: Long = 0,
    val city: String = "",
    val street: String = ""
)

fun Address.toItem() = AddressItem(addressId, employeeId, homeNumber, city, street)

fun AddressItem.toDomain() = Address(addressId, employeeId, homeNumber, city, street)

fun List<Address>.toItems() = map { it.toItem() }

fun List<AddressItem>.toDomains() = map { it.toDomain() }
