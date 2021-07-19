package com.example.app.domain

import com.example.app.data.db.dao.EmployeeAddressConnector
import com.example.app.data.db.entity.toDomains
import com.example.app.data.db.entity.toEntities
import com.example.app.data.db.entity.toEntity
import com.example.app.domain.entity.Address
import com.example.app.domain.entity.Employee
import com.example.app.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmployeeRepositoryImpl(private val employeeAddressConnector: EmployeeAddressConnector) :
    EmployeeRepository {
    override suspend fun getAllEmployee(): Flow<List<Employee>> =
        employeeAddressConnector.employeeFlow().map { it.toDomains() }

    override suspend fun saveEmployee(employee: Employee): Result<Unit> =
        safeCall { employeeAddressConnector.saveEmployee(employee.toEntities()) }

    override suspend fun saveEmployeeAddress(address: Address): Result<Unit> =
        safeCall { employeeAddressConnector.saveEmployeeAddress(address.toEntity()) }

    override suspend fun deleteEmployee(employee: Employee): Result<Unit> =
        safeCall { employeeAddressConnector.deleteEmployee(employee.toEntities()) }

    override suspend fun deleteAddress(address: Address): Result<Unit> =
        safeCall { employeeAddressConnector.deleteAddress(address.toEntity()) }

    override suspend fun updateEmployeeAddress(address: Address): Result<Unit> =
        safeCall { employeeAddressConnector.updateAddress(address.toEntity()) }
}
