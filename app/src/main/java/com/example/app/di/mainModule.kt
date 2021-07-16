package com.example.app.di

import com.example.app.Database
import com.example.app.data.db.AppDatabase
import com.example.app.data.db.AppDatabaseImpl
import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val mainModule = module {

    single {
        AndroidSqliteDriver(
            schema = Database.Schema,
            context = androidApplication(),
            name = AppDatabase.NAME
        )
    }

    single { Database(driver = get()) }
    single { AppDatabaseImpl(database = get()) }
}
