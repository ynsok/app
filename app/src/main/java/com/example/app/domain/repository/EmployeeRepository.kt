package com.example.app.domain.repository

import com.example.app.domain.Result
import com.example.app.domain.entity.Address
import com.example.app.domain.entity.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    suspend fun getAllEmployee(): Flow<List<Employee>>
    suspend fun saveEmployee(employee: Employee): Result<Unit>
    suspend fun deleteEmployee(employee: Employee): Result<Unit>
    suspend fun deleteAddress(address: Address): Result<Unit>
}
