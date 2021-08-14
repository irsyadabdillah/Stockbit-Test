package com.stockbit.hiring.model

import com.google.gson.annotations.SerializedName

data class WatchlistResponse(
    @SerializedName("Data")
    val data: ArrayList<DataResponse>
)













