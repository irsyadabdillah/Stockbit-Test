package com.stockbit.hiring.remote

class RemoteDatasource(private val apiService: ApiService) {

    suspend fun gethWatchlistData() = apiService.getWatchlistResponse()

}