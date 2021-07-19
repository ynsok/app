package com.example.app.ui

import com.example.app.domain.entity.Employee
import com.example.app.domain.useCase.*
import com.example.app.ui.entity.AddressItem
import com.example.app.ui.entity.EmployeeItem
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class EmployeeViewModelTest {
    private lateinit var employeeViewModel: EmployeeViewModel
    private val getAllEmployeeUseCase: GetAllEmployeeUseCase = mockk(relaxed = true)
    private val saveEmployeeUseCase: SaveEmployeeUseCase = mockk(relaxed = true)
    private val deleteAddressUseCase: DeleteAddressUseCase = mockk(relaxed = true)
    private val deleteEmployeeUseCase: DeleteEmployeeUseCase = mockk(relaxed = true)
    private val updateEmployeeAddressUseCase: UpdateEmployeeAddressUseCase = mockk(relaxed = true)
    private val saveEmployeeAddressUseCase: SaveEmployeeAddressUseCase = mockk(relaxed = true)
    private val addressItem: AddressItem = mockk(relaxed = true)
    private val employee: Employee = mockk(relaxed = true)
    private val employeeItem: EmployeeItem = mockk(relaxed = true)
    private val dispatcher = TestCoroutineDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        employeeViewModel = EmployeeViewModel(
            getAllEmployeeUseCase,
            saveEmployeeUseCase,
            deleteAddressUseCase,
            deleteEmployeeUseCase,
            updateEmployeeAddressUseCase,
            saveEmployeeAddressUseCase
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when getEmployees is invoked then employees is returned`() = runBlockingTest() {
        val employees = listOf(employee)
        coEvery { getAllEmployeeUseCase.run() } returns flowOf(employees)
        employeeViewModel.getEmployees()
            .take(1)
            .onEach {
                assert(it.size == employees.size)
            }.collect()

        coVerify { getAllEmployeeUseCase.run() }
    }

    @Test
    fun `when saveEmployeeAddress is invoked then saveEmployeeAddressUseCase is called`() =
        runBlocking {
            employeeViewModel.saveEmployeeAddress(addressItem)

            coVerify { saveEmployeeAddressUseCase.run(any()) }
        }

    @Test
    fun `when updateEmployeeAddress is invoked then updateEmployeeAddressUseCase is called`() =
        runBlocking {
            employeeViewModel.updateEmployeeAddress(addressItem)

            coVerify { updateEmployeeAddressUseCase.run(any()) }
        }

    @Test
    fun `when saveEmployee is invoked then saveEmployeeUseCase is called`() =
        runBlocking {
            employeeViewModel.saveEmployee(employeeItem)

            coVerify { saveEmployeeUseCase.run(any()) }
        }

    @Test
    fun `when deleteEmployee is invoked then deleteEmployeeUseCase is called`() =
        runBlocking {
            employeeViewModel.deleteEmployee(employeeItem)

            coVerify { deleteEmployeeUseCase.run(any()) }
        }

    @Test
    fun `when deleteAddress is invoked then deleteAddressUseCase is called`() =
        runBlocking {
            employeeViewModel.deleteAddress(addressItem)

            coVerify { deleteAddressUseCase.run(any()) }
        }
}