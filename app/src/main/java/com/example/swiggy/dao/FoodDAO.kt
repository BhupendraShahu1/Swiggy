package com.example.swiggy.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.swiggy.model.FoodOrderItem

@Dao
interface FoodDAO {
    @Insert
    fun insertData(userEntity: List<FoodOrderItem>)


    @Query("SELECT * FROM  FoodItem")
    fun getAllFoodData(): LiveData<List<FoodOrderItem>>


    @Query("SELECT * FROM FoodItem WHERE tableAId = :tableAId")
    fun getItemsRelatedToTableA(tableAId: Long): LiveData<List<FoodOrderItem>>

    @Query("UPDATE FoodItem SET itemNo = :itemCount WHERE foodId = :itemId")
    suspend fun updateFoodCountItem(itemId: Int, itemCount: Int)
}