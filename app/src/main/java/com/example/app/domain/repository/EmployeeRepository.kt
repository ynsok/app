package com.example.app.domain.repository

import com.example.app.domain.Result
import com.example.app.domain.entity.Address
import com.example.app.domain.entity.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    fun getAllEmployee(): Flow<List<Employee>>
    suspend fun saveEmployee(employee: Employee): Result<Unit>
    suspend fun saveEmployeeAddress(address: Address): Result<Unit>
    suspend fun deleteEmployee(employee: Employee): Result<Unit>
    suspend fun deleteEmployeeAddress(address: Address): Result<Unit>
    suspend fun updateEmployeeAddress(address: Address): Result<Unit>
}
