package com.stockbit.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class WatchlistResponse(

    @SerializedName("Data")
    val data: List<DataResponse>
)













