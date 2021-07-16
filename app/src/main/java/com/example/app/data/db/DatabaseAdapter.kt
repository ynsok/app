package com.example.app.data.db

import com.example.app.domain.entity.Gender
import com.squareup.sqldelight.ColumnAdapter

val genderAdapter = object : ColumnAdapter<Gender, String> {
    override fun decode(databaseValue: String) = Gender.valueOf(databaseValue)

    override fun encode(value: Gender) = value.name
}