package com.example.app.domain.useCase

import com.example.app.domain.entity.Employee
import com.example.app.domain.repository.EmployeeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DeleteEmployeeUseCaseTest {
    private lateinit var deleteEmployeeUseCase: DeleteEmployeeUseCase
    private val employeeRepository: EmployeeRepository = mockk(relaxed = true)
    private val employee: Employee = mockk(relaxed = true)

    @Before
    fun setup() {
        deleteEmployeeUseCase = DeleteEmployeeUseCase(employeeRepository)
    }

    @Test
    fun `when run is invoked deleteEmployee is Called`() = runBlocking {
        deleteEmployeeUseCase.run(employee)

        coVerify { employeeRepository.deleteEmployee(employee) }

    }
}