package com.example.app.domain

import com.example.app.data.db.dao.EmployeeAddressConnector
import com.example.app.data.db.entity.toDomains
import com.example.app.data.db.entity.toEntities
import com.example.app.domain.entity.Employee
import com.example.app.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmployeeRepositoryImpl(private val employeeAddressConnector: EmployeeAddressConnector) :
    EmployeeRepository {
    override suspend fun getAllEmployee(): Flow<List<Employee>> =
        employeeAddressConnector.selectAllEmployee().map { it.toDomains() }

    override suspend fun saveEmployee(employee: Employee): Result<Unit> =
        safeCall { employeeAddressConnector.insertOrReplace(employee.toEntities()) }

}