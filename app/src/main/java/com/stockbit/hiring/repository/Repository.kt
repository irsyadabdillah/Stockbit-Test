package com.stockbit.hiring.repository

import com.stockbit.hiring.remote.RemoteDatasource


class Repository(private val remoteDatasource: RemoteDatasource) {

    suspend fun getWatchlist() = remoteDatasource.fetchWatchlistAsync()

}