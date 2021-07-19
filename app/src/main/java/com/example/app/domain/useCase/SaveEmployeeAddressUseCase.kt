package com.example.app.domain.useCase

import com.example.app.domain.entity.Address
import com.example.app.domain.repository.EmployeeRepository

class SaveEmployeeAddressUseCase(private val employeeRepository: EmployeeRepository) {

    suspend fun run(address: Address) = employeeRepository.saveEmployeeAddress(address)
}
