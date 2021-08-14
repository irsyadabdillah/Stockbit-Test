package com.stockbit.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
data class CoinInfo(
    @PrimaryKey
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String = "",
    @SerializedName("FullName")
    val fullName: String = "",
    @SerializedName("Type")
    val type: Int? = null
)