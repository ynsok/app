package com.example.app.di

import com.example.app.Database
import com.example.app.data.db.dao.AddressDao
import com.example.app.data.db.dao.EmployeeAddressConnector
import com.example.app.data.db.dao.EmployeeDao
import org.koin.dsl.module

val daoModule = module {
    single { EmployeeAddressConnector(employeeDao = get(), addressDao = get()) }
    single { EmployeeDao(employeeQueries = get()) }
    single { AddressDao(addressDbQueries = get()) }
}

val queriesModule = module {
    single { get<Database>().employeeDbQueries }
    single { get<Database>().addressDbQueries }
}
