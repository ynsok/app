package com.example.app.domain.useCase

import com.example.app.domain.entity.Address
import com.example.app.domain.repository.EmployeeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DeleteAddressUseCaseTest {
    private lateinit var deleteAddressUseCase: DeleteAddressUseCase
    private val employeeRepository: EmployeeRepository = mockk(relaxed = true)
    private val address: Address = mockk(relaxed = true)


    @Before
    fun setup() {
        deleteAddressUseCase = DeleteAddressUseCase(employeeRepository)
    }

    @Test
    fun `when run is invoked deleteEmployeeAddress is Called`() = runBlocking {
        deleteAddressUseCase.run(address)

        coVerify { employeeRepository.deleteEmployeeAddress(address) }

    }
}