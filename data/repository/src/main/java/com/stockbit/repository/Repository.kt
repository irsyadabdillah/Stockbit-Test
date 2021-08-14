package com.stockbit.repository

import com.stockbit.local.dao.ExampleDao
import com.stockbit.model.WatchlistResponse
import com.stockbit.remote.RemoteDatasource
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow



class Repository(private val remoteDatasource: RemoteDatasource) {

    suspend fun getWatchlist() = remoteDatasource.fetchWatchlistAsync()

}