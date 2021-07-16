package com.example.app.data.db

import db.EmployeeQueries

interface AppDatabase {
    fun employeeQueries(): EmployeeQueries

    companion object {
        const val NAME = "database_name.db"
    }
}
