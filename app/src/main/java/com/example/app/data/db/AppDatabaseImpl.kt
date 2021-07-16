package com.example.app.data.db

import com.example.app.Database

class AppDatabaseImpl(private val database: Database) : AppDatabase {
    override fun employeeDbQueries() = database.employeeDbQueries
    override fun addressDbQueries() = database.addressDbQueries
}
