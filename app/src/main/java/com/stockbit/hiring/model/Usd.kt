package com.stockbit.hiring.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
data class Usd(
    @SerializedName("CHANGE24HOUR")
    val change24hour: Double? = null,
    @SerializedName("PRICE")
    val price: Double? = null
)
