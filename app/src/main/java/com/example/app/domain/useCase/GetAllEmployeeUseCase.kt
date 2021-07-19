package com.example.app.domain.useCase

import com.example.app.domain.repository.EmployeeRepository

class GetAllEmployeeUseCase(private val employeeRepository: EmployeeRepository) {

    fun run() = employeeRepository.getAllEmployee()
}
