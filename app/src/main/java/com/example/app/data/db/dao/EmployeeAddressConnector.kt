package com.example.app.data.db.dao

import com.example.app.data.db.entity.AddressEntity
import com.example.app.data.db.entity.EmployeeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class EmployeeAddressConnector(
    private val employeeDao: EmployeeDao,
    private val addressDao: AddressDao
) {
    fun saveEmployee(employee: EmployeeEntity) =
        employeeDao.insertOrReplaceEmployee(employee)

    fun saveEmployeeAddress(addressEntity: AddressEntity) =
        addressDao.insertOrUpdateAddress(addressEntity)

    fun updateAddress(addressEntity: AddressEntity) = addressDao.updateAddress(addressEntity)

    fun employeeFlow(): Flow<List<EmployeeEntity>> {
        val employeeFlow = employeeDao.getAllEmployees()
        val addressesFlow = addressDao.getAllAddresses()
        return employeeFlow.combine(addressesFlow) { employees, _ ->
            employees.map { employee ->
                val addresses = addressDao.selectAllAddressesByEmployeeId(employee.employeeId)
                employee.copy(addressEntity = addresses)
            }
        }
    }

    fun deleteEmployee(employee: EmployeeEntity) = employeeDao.deleteEmployee(employee)

    fun deleteAddress(addressEntity: AddressEntity) = addressDao.deleteAddress(addressEntity)
}
