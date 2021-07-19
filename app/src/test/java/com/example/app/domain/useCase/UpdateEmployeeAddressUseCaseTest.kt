package com.example.app.domain.useCase

import com.example.app.domain.entity.Address
import com.example.app.domain.repository.EmployeeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UpdateEmployeeAddressUseCaseTest {
    private lateinit var updateEmployeeAddressUseCase: UpdateEmployeeAddressUseCase
    private val employeeRepository: EmployeeRepository = mockk(relaxed = true)
    private val address: Address = mockk(relaxed = true)

    @Before
    fun setup() {
        updateEmployeeAddressUseCase = UpdateEmployeeAddressUseCase(employeeRepository)
    }

    @Test
    fun `when run is invoked updateEmployeeAddress is Called`() = runBlocking {
        updateEmployeeAddressUseCase.run(address)

        coVerify { employeeRepository.updateEmployeeAddress(address) }
    }
}
