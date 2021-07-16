package com.example.app

import android.app.Application
import com.example.app.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() = startKoin {
        androidContext(this@App)
        androidLogger()
        loadKoinModules(
            listOf(
                mainModule, queriesModule, daoModule, repositoryModule, useCases,
                viewModel
            )
        )
    }
}
