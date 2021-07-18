package com.example.app.data.db.dao

import com.example.app.data.db.entity.EmployeeEntity
import com.example.app.data.db.entity.toEntities
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import db.EmployeeDbQueries
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class EmployeeDao(private val employeeQueries: EmployeeDbQueries) {

    fun getAllEmployees() = employeeQueries.selectAllEmployee()
        .asFlow()
        .mapToList()
        .distinctUntilChanged()
        .map { it.toEntities() }

    fun insertOrReplaceEmployee(employee: EmployeeEntity) =
        with(employee) {
            employeeQueries.insertOrReplace(employeeId, firstName, lastName, age, gender)
        }

    fun deleteEmployee(employee: EmployeeEntity) =
        employeeQueries.deleteEmployee(employee.employeeId)
}
