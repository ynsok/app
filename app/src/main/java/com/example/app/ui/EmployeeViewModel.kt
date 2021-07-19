package com.example.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.useCase.DeleteAddressUseCase
import com.example.app.domain.useCase.DeleteEmployeeUseCase
import com.example.app.domain.useCase.GetAllEmployeeUseCase
import com.example.app.domain.useCase.SaveEmployeeAddressUseCase
import com.example.app.domain.useCase.SaveEmployeeUseCase
import com.example.app.domain.useCase.UpdateEmployeeAddressUseCase
import com.example.app.ui.entity.AddressItem
import com.example.app.ui.entity.EmployeeItem
import com.example.app.ui.entity.toDomain
import com.example.app.ui.entity.toItem
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val getAllEmployeeUseCase: GetAllEmployeeUseCase,
    private val saveEmployeeUseCase: SaveEmployeeUseCase,
    private val deleteAddressUseCase: DeleteAddressUseCase,
    private val deleteEmployeeUseCase: DeleteEmployeeUseCase,
    private val updateEmployeeAddressUseCase: UpdateEmployeeAddressUseCase,
    private val saveEmployeeAddressUseCase: SaveEmployeeAddressUseCase
) : ViewModel() {

    suspend fun getEmployees() = getAllEmployeeUseCase.run()
        .map { employees ->
            employees
                .map { employee ->
                    employee.toItem()
                }
        }

    fun saveEmployeeAddress(addressItem: AddressItem) = viewModelScope.launch {
        saveEmployeeAddressUseCase.run(addressItem.toDomain())
    }

    fun updateEmployeeAddress(addressItem: AddressItem) = viewModelScope.launch {
        updateEmployeeAddressUseCase.run(addressItem.toDomain())
    }

    fun saveEmployee(employee: EmployeeItem) = viewModelScope.launch {
        saveEmployeeUseCase.run(employee.toDomain())
    }

    fun deleteEmployee(employee: EmployeeItem) = viewModelScope.launch {
        deleteEmployeeUseCase.run(employee.toDomain())
    }

    fun deleteAddress(addressItem: AddressItem) = viewModelScope.launch {
        deleteAddressUseCase.run(addressItem.toDomain())
    }
}
