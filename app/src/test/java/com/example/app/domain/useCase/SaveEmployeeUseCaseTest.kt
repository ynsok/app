package com.example.app.domain.useCase

import com.example.app.domain.entity.Employee
import com.example.app.domain.repository.EmployeeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SaveEmployeeUseCaseTest {
    private lateinit var saveEmployeeUseCase: SaveEmployeeUseCase
    private val employeeRepository: EmployeeRepository = mockk(relaxed = true)
    private val employee: Employee = mockk(relaxed = true)

    @Before
    fun setup() {
        saveEmployeeUseCase = SaveEmployeeUseCase(employeeRepository)
    }

    @Test
    fun `when run is invoked saveEmployee is Called`() = runBlocking {
        saveEmployeeUseCase.run(employee)

        coVerify { employeeRepository.saveEmployee(employee) }
    }
}
