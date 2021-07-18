package com.example.app.domain.useCase

import com.example.app.domain.entity.Employee
import com.example.app.domain.repository.EmployeeRepository

class SaveEmployeeUseCase(private val employeeRepository: EmployeeRepository) {

    suspend fun run(employee: Employee) = employeeRepository.saveEmployee(employee)
}
