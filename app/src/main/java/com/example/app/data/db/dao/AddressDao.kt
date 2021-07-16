package com.example.app.data.db.dao

import com.example.app.data.db.entity.AddressEntity
import com.example.app.data.db.entity.toEntities
import db.AddressDbQueries

class AddressDao(private val addressDbQueries: AddressDbQueries) {

    fun saveAddressWhenNotExists(addressEntity: AddressEntity) =
        if (addressExist(addressEntity).not()) {
            insertOrReplace(addressEntity)
        } else Unit

    private fun addressExist(addressEntity: AddressEntity) = with(addressEntity) {
        addressDbQueries.addressExists(homeNumber, city, street).executeAsOne()
    }

    private fun insertOrReplace(addressEntity: AddressEntity) = with(addressEntity) {
        addressDbQueries.insertOrReplace(homeNumber, city, street, employeeId)
    }

    fun selectAllAddressesByEmployeeId(employeeId: Long) =
        addressDbQueries.selectAllAddrressesByEmployeeId(employeeId).executeAsList().toEntities()
}