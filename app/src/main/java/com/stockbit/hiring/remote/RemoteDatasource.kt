package com.stockbit.hiring.remote

class RemoteDatasource(private val apiService: ApiService) {

    suspend fun fetchWatchlistAsync() = apiService.fetchWatchlistAsync()

}