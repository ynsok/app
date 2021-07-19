package com.example.app.data.db.dao

import com.example.app.data.db.entity.AddressEntity
import com.example.app.data.db.entity.EmployeeEntity
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

class EmployeeAddressConnectorTest {
    private lateinit var employeeAddressConnector: EmployeeAddressConnector
    private val employeeDao: EmployeeDao = mockk(relaxed = true)
    private val addressDao: AddressDao = mockk(relaxed = true)
    private val address: AddressEntity = mockk(relaxed = true)
    private val employee: EmployeeEntity = mockk(relaxed = true)

    @Before
    fun setup() {
        employeeAddressConnector = EmployeeAddressConnector(employeeDao, addressDao)
    }

    @Test
    fun `when employeeFlow is invoked then employees is returned`() = runBlocking {
        val employees = listOf(employee)
        val address = listOf(address)
        coEvery { employeeDao.getAllEmployees() } returns flowOf(employees)
        coEvery { addressDao.getAllAddresses() } returns flowOf(address)
        coEvery { addressDao.selectAllAddressesByEmployeeId(any()) } returns address
        employeeAddressConnector.employeeFlow()
            .take(1)
            .onEach {
                println(it)
                assert(it.size == employees.size)
            }
            .collect()

        coVerify { addressDao.selectAllAddressesByEmployeeId(any()) }
    }
}
