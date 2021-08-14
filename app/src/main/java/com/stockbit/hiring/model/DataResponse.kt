package com.stockbit.hiring.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
data class DataResponse(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfo,
    @SerializedName("RAW")
    val raw: Raw
)
