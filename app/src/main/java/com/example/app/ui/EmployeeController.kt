package com.example.app.ui

import com.airbnb.epoxy.TypedEpoxyController
import com.example.app.ui.entity.AddressItem
import com.example.app.ui.entity.EmployeeItem
import com.example.app.ui.model.addEmployeeView
import com.example.app.ui.model.addressItemView
import com.example.app.ui.model.employeeItemView

const val ADD_EMPLOYEE_BUTTON_ID = "add_employee_button_id"

class EmployeeController(
    private val onEmployeeRemove: (EmployeeItem) -> Unit,
    private val onEditAddress: (AddressItem) -> Unit,
    private val onEditEmployee: (EmployeeItem) -> Unit,
    private val onAddressRemove: (AddressItem) -> Unit,
    private val addEmployee: () -> Unit,
    private val addAddress: (EmployeeItem) -> Unit
) :
    TypedEpoxyController<List<EmployeeItem>>() {
    override fun buildModels(employees: List<EmployeeItem>) {
        addEmployeeView {
            id(ADD_EMPLOYEE_BUTTON_ID)
            onAddEmployeeClick(this@EmployeeController.addEmployee)
        }
        employees.forEach { employeeItem ->
            employeeItemView {
                id(employeeItem.employeeId)
                employee(employeeItem)
                onRemoveClick { this@EmployeeController.onEmployeeRemove.invoke(employeeItem) }
                onEditClick { this@EmployeeController.onEditEmployee.invoke(employeeItem) }
                onAddAddress { this@EmployeeController.addAddress.invoke(employeeItem) }
            }
            employeeItem.addressItem.forEachIndexed { index, addressItem ->
                addressItemView {
                    id(addressItem.addressId)
                    address(addressItem)
                    addressIndex(index + 1)
                    onEditClick {
                        this@EmployeeController.onEditAddress.invoke(addressItem)
                    }
                    onRemoveClick { this@EmployeeController.onAddressRemove.invoke(addressItem) }
                }
            }
        }
    }
}
