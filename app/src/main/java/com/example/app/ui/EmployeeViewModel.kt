package com.example.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.useCase.DeleteAddressUseCase
import com.example.app.domain.useCase.DeleteEmployeeUseCase
import com.example.app.domain.useCase.GetAllEmployeeUseCase
import com.example.app.domain.useCase.SaveEmployeeUseCase
import com.example.app.ui.entity.AddressItem
import com.example.app.ui.entity.EmployeeItem
import com.example.app.ui.entity.toDomain
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val getAllEmployeeUseCase: GetAllEmployeeUseCase,
    private val saveEmployeeUseCase: SaveEmployeeUseCase,
    private val deleteAddressUseCase: DeleteAddressUseCase,
    private val deleteEmployeeUseCase: DeleteEmployeeUseCase
) : ViewModel() {

    suspend fun getEmployees() = getAllEmployeeUseCase.run()

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
