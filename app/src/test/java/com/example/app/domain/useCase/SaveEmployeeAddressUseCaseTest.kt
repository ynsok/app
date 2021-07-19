package com.example.app.domain.useCase

import com.example.app.domain.entity.Address
import com.example.app.domain.repository.EmployeeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SaveEmployeeAddressUseCaseTest {
    private lateinit var saveEmployeeAddressUseCase: SaveEmployeeAddressUseCase
    private val employeeRepository: EmployeeRepository = mockk(relaxed = true)
    private val address: Address = mockk(relaxed = true)


    @Before
    fun setup() {
        saveEmployeeAddressUseCase = SaveEmployeeAddressUseCase(employeeRepository)
    }

    @Test
    fun `when run is invoked saveEmployeeAddress is Called`() = runBlocking {
        saveEmployeeAddressUseCase.run(address)

        coVerify { employeeRepository.saveEmployeeAddress(address) }

    }
}