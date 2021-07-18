package com.example.app.data.db.dao

import com.example.app.data.db.entity.AddressEntity
import com.example.app.data.db.entity.toEntities
import db.AddressDbQueries

class AddressDao(private val addressDbQueries: AddressDbQueries) {

    fun insertOrUpdateAddress(addressEntity: AddressEntity) =
        if (addressExist(addressEntity).not()) {
            insertAddress(addressEntity)
        } else updateAddress(addressEntity)

    private fun updateAddress(addressEntity: AddressEntity) = with(addressEntity) {
        addressDbQueries.updateAddress(homeNumber, city, street, addressId, employeeId)
    }

    private fun addressExist(addressEntity: AddressEntity) = with(addressEntity) {
        addressDbQueries.addressExists(homeNumber, city, street, employeeId).executeAsOne()
    }

    private fun insertAddress(addressEntity: AddressEntity) = with(addressEntity) {
        addressDbQueries.insertAddress(homeNumber, city, street, employeeId)
    }

    fun selectAllAddressesByEmployeeId(employeeId: Long) =
        addressDbQueries.selectAllAddrressesByEmployeeId(employeeId).executeAsList().toEntities()

    fun deleteAddress(addressEntity: AddressEntity) =
        addressDbQueries.deleteAddress(addressEntity.addressId)
}
