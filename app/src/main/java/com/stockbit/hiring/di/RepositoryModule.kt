package com.stockbit.hiring.di

import com.stockbit.repository.Repository
import org.koin.dsl.module

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
val repositoryModule = module {
    factory {
        Repository(get())
    }
}