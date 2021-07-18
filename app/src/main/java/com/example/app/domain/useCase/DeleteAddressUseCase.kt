package com.example.app.domain.useCase

import com.example.app.domain.entity.Address
import com.example.app.domain.repository.EmployeeRepository

class DeleteAddressUseCase(private val employee: EmployeeRepository) {

    suspend fun run(address: Address) = employee.deleteAddress(address)
}