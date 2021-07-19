package com.example.app.data.db.dao

import com.example.app.data.db.entity.AddressEntity
import com.example.app.data.db.entity.toEntities
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import db.AddressDbQueries
import kotlinx.coroutines.flow.map

class AddressDao(private val addressDbQueries: AddressDbQueries) {

    fun insertOrUpdateAddress(addressEntity: AddressEntity) =
        if (addressExist(addressEntity).not()) {
            insertAddress(addressEntity)
        } else {
            Unit
        }

    fun updateAddress(addressEntity: AddressEntity) = with(addressEntity) {
        addressDbQueries.updateAddress(homeNumber, city, street, addressId, employeeId)
    }

    private fun addressExist(addressEntity: AddressEntity) = with(addressEntity) {
        addressDbQueries.addressExists(homeNumber, city, street, employeeId).executeAsOne()
    }

    private fun insertAddress(addressEntity: AddressEntity) = with(addressEntity) {
        addressDbQueries.insertAddress(homeNumber, city, street, employeeId)
    }

    fun getAllAddresses() =
        addressDbQueries.selectAllAddrresses()
            .asFlow()
            .mapToList()
            .map { it.toEntities() }

    fun selectAllAddressesByEmployeeId(employeeId: Long) =
        addressDbQueries.selectAllAddrressesByEmployeeId(employeeId).executeAsList().toEntities()

    fun deleteAddress(addressEntity: AddressEntity) =
        addressDbQueries.deleteAddress(addressEntity.addressId)
}
