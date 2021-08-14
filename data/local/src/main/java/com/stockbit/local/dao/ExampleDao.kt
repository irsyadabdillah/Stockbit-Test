package com.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.stockbit.model.WatchlistResponse

@Dao
abstract class ExampleDao: BaseDao<WatchlistResponse>() {

    @Query("SELECT * FROM WatchlistResponse WHERE name = :name LIMIT 1")
    abstract suspend fun getExample(name: String): WatchlistResponse

    suspend fun save(data: WatchlistResponse) {
        insert(data)
    }

    suspend fun save(data: List<WatchlistResponse>) {
        insert(data)
    }
}