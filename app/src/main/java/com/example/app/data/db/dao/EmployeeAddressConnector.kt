package com.example.app.data.db.dao

import com.example.app.data.db.entity.EmployeeEntity
import kotlinx.coroutines.flow.map

class EmployeeAddressConnector(
    private val employeeDao: EmployeeDao,
    private val addressDao: AddressDao
) {

    fun insertOrReplace(employee: EmployeeEntity) {
        employeeDao.insertOrReplaceEmployee(employee)

        employee.addressEntity?.forEach {
            addressDao.saveAddressWhenNotExists(it)
        }
    }

    fun selectAllEmployee() =
        employeeDao.getAllEmployees().map { list ->
            list.map { employee ->
                val addresses = addressDao.selectAllAddressesByEmployeeId(employee.employeeId)
                employee.copy(addressEntity = addresses)
            }
        }
}