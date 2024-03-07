package com.example.swiggy.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.swiggy.model.FoodOrderItem
import com.example.swiggy.model.Restaurants

@Dao
interface RestaurantsDAO {
    @Insert
    fun insertData(userEntity: List<Restaurants>)


    @Query("SELECT * FROM  RestaurantsItem")
    fun getAllRestaurantsData(): LiveData<List<Restaurants>>
}