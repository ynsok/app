package com.example.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.useCase.GetAllEmployeeUseCase
import com.example.app.domain.useCase.SaveEmployeeUseCase
import com.example.app.ui.entity.EmployeeItem
import com.example.app.ui.entity.toDomain
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val getAllEmployeeUseCase: GetAllEmployeeUseCase,
    private val saveEmployeeUseCase: SaveEmployeeUseCase
) : ViewModel() {

    suspend fun getEmployees() = getAllEmployeeUseCase.run()

    fun saveEmployee(employee: EmployeeItem) = viewModelScope.launch {
        saveEmployeeUseCase.run(employee.toDomain())
    }
}