package com.example.app.domain.repository

import com.example.app.domain.Result
import com.example.app.domain.entity.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    suspend fun getAllEmployee(): Flow<List<Employee>>
    suspend fun saveEmployee(employee: Employee): Result<Unit>
}