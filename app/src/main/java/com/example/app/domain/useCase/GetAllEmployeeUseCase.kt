package com.example.app.domain.useCase

import com.example.app.domain.repository.EmployeeRepository

class GetAllEmployeeUseCase(private val employeeRepository: EmployeeRepository) {

    suspend fun run() = employeeRepository.getAllEmployee()
}
