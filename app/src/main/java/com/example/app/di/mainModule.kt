package com.example.app.di

import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.app.Database
import com.example.app.data.db.AppDatabase
import com.example.app.data.db.AppDatabaseImpl
import com.example.app.data.db.genderAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import db.EmployeeDb
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val mainModule = module {

    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = Database.Schema,
            context = androidApplication(),
            name = AppDatabase.NAME,
            callback = object : AndroidSqliteDriver.Callback(Database.Schema) {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    db.execSQL("PRAGMA foreign_keys=ON;")
                }
            }
        )
    }

    single { Database(driver = get(), EmployeeDbAdapter = EmployeeDb.Adapter(genderAdapter)) }
    single { AppDatabaseImpl(database = get()) }
}
