package com.stockbit.remote

/**
 * Implementation of [ApiService] interface
 */
class RemoteDatasource(private val apiService: ApiService) {

    suspend fun fetchWatchlistAsync() = apiService.fetchWatchlistAsync()

}