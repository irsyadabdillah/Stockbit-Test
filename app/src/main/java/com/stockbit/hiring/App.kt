package com.stockbit.hiring

import android.app.Application
import com.stockbit.hiring.di.appComponent
import com.stockbit.hiring.di.networkModule
import com.stockbit.hiring.di.repositoryModule
import com.stockbit.hiring.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // CONFIGURATION ---
    open fun configureDi() =
        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(viewModelModule)
            modules(repositoryModule)
            provideComponent()

        }

    // PUBLIC API ---
    open fun provideComponent() = appComponent
}