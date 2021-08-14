package com.stockbit.hiring.remote

import com.stockbit.common.utils.Constant
import com.stockbit.hiring.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/top/totaltoptiervolfull")
    suspend fun fetchWatchlistAsync(
        @Query("tsym") tsym: String = Constant.TSYM,
        @Query("page") page: Int = Constant.PAGE
    ): Response<DataResponse>

}



