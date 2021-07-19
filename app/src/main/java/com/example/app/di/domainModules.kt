package com.example.app.di

import com.example.app.domain.EmployeeRepositoryImpl
import com.example.app.domain.repository.EmployeeRepository
import com.example.app.domain.useCase.DeleteAddressUseCase
import com.example.app.domain.useCase.DeleteEmployeeUseCase
import com.example.app.domain.useCase.GetAllEmployeeUseCase
import com.example.app.domain.useCase.SaveEmployeeAddressUseCase
import com.example.app.domain.useCase.SaveEmployeeUseCase
import com.example.app.domain.useCase.UpdateEmployeeAddressUseCase
import org.koin.dsl.module

val repositoryModule = module {
    single<EmployeeRepository> { EmployeeRepositoryImpl(employeeAddressConnector = get()) }
}
val useCasesModule = module {
    factory { GetAllEmployeeUseCase(employeeRepository = get()) }
    factory { SaveEmployeeUseCase(employeeRepository = get()) }
    factory { DeleteEmployeeUseCase(employeeRepository = get()) }
    factory { DeleteAddressUseCase(employeeRepository = get()) }
    factory { UpdateEmployeeAddressUseCase(employeeRepository = get()) }
    factory { SaveEmployeeAddressUseCase(employeeRepository = get()) }
}
