package com.example.app.data.db.dao

import com.example.app.data.db.entity.AddressEntity
import com.example.app.data.db.entity.EmployeeEntity
import kotlinx.coroutines.flow.map

class EmployeeAddressConnector(
    private val employeeDao: EmployeeDao,
    private val addressDao: AddressDao
) {

    fun insertOrReplace(employee: EmployeeEntity) {
        employeeDao.insertOrReplaceEmployee(employee)

        employee.addressEntity?.forEach {
            addressDao.insertOrUpdateAddress(it)
        }
    }

    fun selectAllEmployee() =
        employeeDao.getAllEmployees().map { list ->
            list.map { employee ->
                val addresses = addressDao.selectAllAddressesByEmployeeId(employee.employeeId)
                employee.copy(addressEntity = addresses)
            }
        }

    fun deleteEmployee(employee: EmployeeEntity) = employeeDao.deleteEmployee(employee)

    fun deleteAddress(addressEntity: AddressEntity) = addressDao.deleteAddress(addressEntity)
}