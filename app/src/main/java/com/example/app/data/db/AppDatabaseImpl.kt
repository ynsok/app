package com.example.app.data.db

import com.example.app.Database

class AppDatabaseImpl(private val database: Database) : AppDatabase {
    override fun employeeQueries() = database.employeeQueries
}
