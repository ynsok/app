package com.example.app.data.db.entity

import com.example.app.domain.entity.Address
import db.AddressDb

data class AddressEntity(
    val addressId: Long = 0,
    val employeeId: Long,
    val homeNumber: Long,
    val city: String,
    val street: String
)

fun AddressDb.toEntity() = AddressEntity(addressId, employeeId, homeNumber, city, street)

fun List<AddressDb>.toEntities() = map { it.toEntity() }

fun AddressEntity.toDomain() = Address(addressId, employeeId, homeNumber, city, street)

fun Address.toEntity() = AddressEntity(addressId, employeeId, homeNumber, city, street)

fun List<AddressEntity>.toDomains() = map { it.toDomain() }

@JvmName("toEntitiesAddress")
fun List<Address>.toEntities() = map { it.toEntity() }
