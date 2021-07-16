package com.example.app.di

import com.example.app.domain.EmployeeRepositoryImpl
import com.example.app.domain.repository.EmployeeRepository
import com.example.app.domain.useCase.GetAllEmployeeUseCase
import com.example.app.domain.useCase.SaveEmployeeUseCase
import org.koin.dsl.module


val repositoryModule = module {
    single<EmployeeRepository> { EmployeeRepositoryImpl(employeeAddressConnector = get()) }
}
val useCases = module {
    factory { GetAllEmployeeUseCase(employeeRepository = get()) }
    factory { SaveEmployeeUseCase(employeeRepository = get()) }
}
