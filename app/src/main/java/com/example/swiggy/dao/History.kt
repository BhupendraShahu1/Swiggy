package com.example.swiggy.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.swiggy.model.HistoryEntity

@Dao
interface History {
    @Query("INSERT INTO history SELECT * FROM cart")
    fun historyTable()

    @Query("SELECT * FROM  history")
    fun getAllHistoryData(): LiveData<List<HistoryEntity>>
}