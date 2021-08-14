package com.stockbit.remote

import com.stockbit.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    object Constant {
        const val LIMIT = 10
        const val TSYM = "USD"
    }

    @GET("data/top/totalvolfull")
    suspend fun fetchWatchlistAsync(
        @Query("limit") limit: Int = Constant.LIMIT,
        @Query("tsym") tsym: String = Constant.TSYM
    ): Response<DataResponse>

}



