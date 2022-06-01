package com.example.app

import androidx.test.core.app.ActivityScenario
import com.example.app.dialog.AddEmployeeDialogScreen
import com.example.app.dialog.AddressEditDialogScreen
import com.example.app.dialog.EmployeeEditDialogScreen
import com.example.app.itemView.AddEmployeeItemView
import com.example.app.itemView.AddressItemView
import com.example.app.itemView.EmployeeItemView
import com.example.app.screen.MainActivityScreen
import com.example.app.ui.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class MainTest : TestCase() {
    lateinit var mainActivity: ActivityScenario<MainActivity>

    @Test
    fun testMainAppFlow() {
        before {
            mainActivity = ActivityScenario.launch(MainActivity::class.java)
        }.after {
            mainActivity.close()
        }.run {
            step("click add new employee") {
                MainActivityScreen {
                    employeeRecycler.firstChild<AddEmployeeItemView> {
                        add_employee_button.click()
                    }
                }
            }

            step("fill fields with employee information") {
                AddEmployeeDialogScreen {
                    editText_employee_id {
                        click()
                        typeText("1235")
                    }
                    editText_firstName {
                        click()
                        typeText("firstName")
                    }
                    editText_lastName {
                        click()
                        typeText("lastName")
                    }
                    editText_age {
                        click()
                        typeText("9")
                    }
                    save_button.click()
                }
            }

            step("check if employee displayed") {
                MainActivityScreen {
                    employeeRecycler.childAt<EmployeeItemView>(1) {
                        employeeName.isVisible()
                        lastName.isVisible()
                        gender.isVisible()
                        addAddress.isVisible()
                        remove.isVisible()
                        edit.isVisible()
                    }
                }
            }

            step("click on add Address") {
                MainActivityScreen {
                    employeeRecycler.childAt<EmployeeItemView>(1) {
                        addAddress.click()
                    }
                }
            }

            step("add first Address") {
                AddressEditDialogScreen {
                    editText_home_number.typeText("123")
                    editText_city.typeText("City")
                    editText_street.typeText("Street")
                    save_button.click()
                }
            }

            step("click on add Address") {
                MainActivityScreen {
                    employeeRecycler.childAt<EmployeeItemView>(1) {
                        addAddress.click()
                    }
                }
            }

            step("add second Address") {
                AddressEditDialogScreen {
                    editText_home_number.typeText("2134")
                    editText_city.typeText("Wroclawe")
                    editText_street.typeText("Wroclawe")
                    save_button.click()
                }
            }
            step("check if first address displayed") {
                MainActivityScreen {
                    employeeRecycler.childAt<AddressItemView>(2) {
                        homeNumber.isVisible()
                        city.isVisible()
                        street.isVisible()
                    }
                }
            }
            step("check if second address displayed") {
                MainActivityScreen {
                    employeeRecycler.childAt<AddressItemView>(3) {
                        homeNumber.isVisible()
                        city.isVisible()
                        street.isVisible()
                    }
                }
            }
            step("click add second employee") {
                MainActivityScreen {
                    employeeRecycler.firstChild<AddEmployeeItemView> {
                        add_employee_button.click()
                    }
                }
            }
            step("fill fields with second employee information") {
                AddEmployeeDialogScreen {
                    editText_employee_id {
                        typeText("2345")
                    }
                    editText_firstName {
                        typeText("Kapitan")
                    }
                    editText_lastName {
                        typeText("lastName")
                    }
                    editText_age {
                        typeText("10")
                    }
                    save_button.click()
                }
            }
            step("check if second employee displayed") {
                MainActivityScreen {
                    employeeRecycler.childAt<EmployeeItemView>(4) {
                        employeeName.isVisible()
                        lastName.isVisible()
                        gender.isVisible()
                        addAddress.isVisible()
                        remove.isVisible()
                        edit.isVisible()
                    }
                }
            }

            step("click on edit button of  second Address") {
                MainActivityScreen {
                    employeeRecycler.childAt<AddressItemView>(3) {
                        editAddress.click()
                    }
                }
            }

            step("edit second Address") {
                AddressEditDialogScreen {
                    editText_home_number {
                        clearText()
                        typeText("123455453")
                    }
                    editText_street {
                        clearText()
                        typeText("asdasdadad")
                    }
                    editText_city {
                        clearText()
                        typeText("asdadd")
                    }
                    save_button.click()
                }
            }

            step("check if second employee is updated") {
                MainActivityScreen {
                    employeeRecycler.childAt<AddressItemView>(3) {
                        homeNumber.hasText("Home Number:123455453")
                        city.hasText("City:asdadd")
                        street.hasText("Street:asdasdadad")
                    }
                }
            }

            step("remove second address") {
                MainActivityScreen {
                    employeeRecycler.childAt<AddressItemView>(3) {
                        remove.click()
                    }
                }
            }

            step("click on edit first Employee") {
                MainActivityScreen {
                    employeeRecycler.childAt<EmployeeItemView>(1) {
                        edit.click()
                    }
                }
            }

            step("edit employee") {
                EmployeeEditDialogScreen {
                    editText_firstName {
                        clearText()
                        typeText("Tytus")
                    }
                    editText_lastName {
                        clearText()
                        typeText("name")
                    }
                    editText_age {
                        clearText()
                        typeText("121312312323")
                    }
                    save.click()
                }
            }

            step("check if first employee updated") {
                MainActivityScreen.employeeRecycler.childAt<EmployeeItemView>(1) {
                    employeeName.hasText("Name:Tytus")
                    lastName.hasText("Last Name:name")
                    age.hasText("Age:121312312323")
                }
            }

            step("remove first employee with address") {
                MainActivityScreen.employeeRecycler.childAt<EmployeeItemView>(1) {
                    remove.click()
                }
            }

            step("remove second employee with address") {
                MainActivityScreen.employeeRecycler.childAt<EmployeeItemView>(1) {
                    remove.click()
                }
            }
        }
    }
}
