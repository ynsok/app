package com.example.app.domain

import com.example.app.data.db.dao.EmployeeAddressConnector
import com.example.app.data.db.entity.toEntity
import com.example.app.domain.entity.Address
import com.example.app.domain.entity.Employee
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class EmployeeRepositoryImplTest {
    private lateinit var employeeRepositoryImpl: EmployeeRepositoryImpl
    private val employeeAddressConnector: EmployeeAddressConnector = mockk(relaxed = true)
    private val address: Address = mockk(relaxed = true)
    private val employee: Employee = mockk(relaxed = true)

    @Before
    fun setup() {
        employeeRepositoryImpl = EmployeeRepositoryImpl(employeeAddressConnector)
    }

    @Test
    fun `when updateEmployeeAddress is invoked then updateAddress is called`() = runBlocking {
        employeeRepositoryImpl.updateEmployeeAddress(address)

        coVerify { employeeAddressConnector.updateAddress(address.toEntity()) }
    }

    @Test
    fun `when deleteEmployeeAddress is invoked then deleteEmployeeAddress is called`() =
        runBlocking {
            employeeRepositoryImpl.deleteEmployeeAddress(address)

            coVerify { employeeAddressConnector.deleteEmployeeAddress(address.toEntity()) }
        }

    @Test
    fun `when deleteEmployee is invoked then deleteEmployee is called`() =
        runBlocking {
            employeeRepositoryImpl.deleteEmployee(employee)

            coVerify { employeeAddressConnector.deleteEmployee(any()) }
        }

    @Test
    fun `when saveEmployeeAddress is invoked then saveEmployeeAddress is called`() =
        runBlocking {
            employeeRepositoryImpl.saveEmployeeAddress(address)

            coVerify { employeeAddressConnector.saveEmployeeAddress(address.toEntity()) }
        }

    @Test
    fun `when saveEmployee is invoked then saveEmployee is called`() =
        runBlocking {
            employeeRepositoryImpl.saveEmployee(employee)

            coVerify { employeeAddressConnector.saveEmployee(any()) }
        }

    @Test
    fun `when getAllEmployee is invoked then employeeFlow is called`() =
        runBlocking {
            employeeRepositoryImpl.getAllEmployee()

            coVerify { employeeAddressConnector.employeeFlow() }
        }
}
