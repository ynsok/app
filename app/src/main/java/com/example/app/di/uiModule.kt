package com.example.app.di

import com.example.app.ui.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EmployeeViewModel(getAllEmployeeUseCase = get(), saveEmployeeUseCase = get()) }
}
