package com.example.app.domain.useCase

import com.example.app.domain.entity.Employee
import com.example.app.domain.repository.EmployeeRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllEmployeeUseCaseTest {
    private lateinit var getAllEmployeeUseCase: GetAllEmployeeUseCase
    private val employeeRepository: EmployeeRepository = mockk(relaxed = true)
    private val employee: Employee = mockk(relaxed = true)

    @Before
    fun setup() {
        getAllEmployeeUseCase = GetAllEmployeeUseCase(employeeRepository)
    }

    @Test
    fun `when run is invoked getAllEmployee is Called`() = runBlocking {
        getAllEmployeeUseCase.run()

        coVerify { employeeRepository.getAllEmployee() }
    }

    @Test
    fun `when run is invoked getAllEmployee is returns employee`() = runBlocking {
        val employees = listOf(employee)
        coEvery { employeeRepository.getAllEmployee() } returns flowOf(employees)
        getAllEmployeeUseCase.run()
            .take(1)
            .onEach { assert(it == employees) }
            .collect()

        coVerify { employeeRepository.getAllEmployee() }
    }
}
