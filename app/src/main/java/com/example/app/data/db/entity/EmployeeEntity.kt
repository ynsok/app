package com.example.app.data.db.entity

import com.example.app.domain.entity.Employee
import com.example.app.domain.entity.Gender
import db.EmployeeDb

data class EmployeeEntity(
    val employeeId: Long,
    val firstName: String,
    val lastName: String,
    val age: Long,
    val gender: Gender,
    val addressEntity: List<AddressEntity>? = emptyList()
)

fun EmployeeDb.toEntity(addresses: List<AddressEntity> = emptyList()) =
    EmployeeEntity(employeeId, firstName, lastName, age, gender, addresses)

fun List<EmployeeDb>.toEntities() = map { it.toEntity() }

fun EmployeeEntity.toDomain() =
    Employee(
        employeeId,
        firstName,
        lastName,
        age,
        gender,
        addressEntity?.toDomains() ?: emptyList()
    )

fun List<EmployeeEntity>.toDomains() = map { it.toDomain() }

fun Employee.toEntities() =
    EmployeeEntity(employeeId, firstName, lastName, age, gender, address.toEntities())
