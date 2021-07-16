package com.example.app.data.db

import db.AddressDbQueries
import db.EmployeeDbQueries

interface AppDatabase {
    fun employeeDbQueries(): EmployeeDbQueries
    fun addressDbQueries(): AddressDbQueries

    companion object {
        const val NAME = "database_name.db"
    }
}
