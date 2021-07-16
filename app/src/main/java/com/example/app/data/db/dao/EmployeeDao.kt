package com.example.app.data.db.dao

import db.EmployeeQueries

class EmployeeDao(private val employeeQueries: EmployeeQueries) {

    fun getAllEmployee() = employeeQueries.selectAllEmployee()
}
