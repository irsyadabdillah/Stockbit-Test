package com.stockbit.hiring.di

import com.stockbit.hiring.ui.watchlist.WatchlistViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
val viewModelModule = module {
    viewModel { WatchlistViewModel(get()) }
}