package com.example.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import com.example.app.ui.dialog.openAddEmployeeDialog
import com.example.app.ui.dialog.openAddressEditDialog
import com.example.app.ui.dialog.openEmployeeEditDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: EmployeeViewModel by viewModel()
    private val mainScope = MainScope()
    private val employeeController =
        EmployeeController(
            onEmployeeRemove = { viewModel.deleteEmployee(it) },
            onAddressRemove = { viewModel.deleteAddress(it) },
            onEditAddress = { address ->
                openAddressEditDialog(address) { updatedAddress ->
                    viewModel.updateEmployeeAddress(
                        updatedAddress
                    )
                }
            },
            onEditEmployee = {
                openEmployeeEditDialog(it) { updatedEmployee ->
                    viewModel.saveEmployee(updatedEmployee)
                }
            },
            addEmployee = {
                openAddEmployeeDialog { employee ->
                    viewModel.saveEmployee(employee)
                }
            },
            addAddress = { employee ->
                openAddressEditDialog { updatedAddress ->
                    viewModel.saveEmployeeAddress(updatedAddress.copy(employeeId = employee.employeeId))
                }
            }
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeRecycler.setController(employeeController)

        viewModel.getEmployees()
            .onEach { employeeController.setData(it) }
            .launchIn(mainScope)
    }

    override fun onDestroy() {
        super.onDestroy()

        mainScope.cancel()
    }
}
