package com.example.app.di

import com.example.app.Database
import com.example.app.data.db.dao.EmployeeDao
import org.koin.dsl.module

val daoModule = module {
    single { EmployeeDao(employeeQueries = get()) }
}

val queriesModule = module {
    single { get<Database>().employeeQueries }
}
