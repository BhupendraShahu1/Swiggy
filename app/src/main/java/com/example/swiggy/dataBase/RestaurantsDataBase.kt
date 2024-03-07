package com.example.swiggy.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.swiggy.dao.Cart
import com.example.swiggy.dao.FoodDAO
import com.example.swiggy.dao.History
import com.example.swiggy.dao.RestaurantsDAO
import com.example.swiggy.model.CartEntity
import com.example.swiggy.model.FoodOrderItem
import com.example.swiggy.model.HistoryEntity
import com.example.swiggy.model.Restaurants

@Database(
    entities = [Restaurants::class, FoodOrderItem::class, CartEntity::class, HistoryEntity::class],
    version = 7,
    exportSchema = false
)
abstract class RestaurantsDataBase : RoomDatabase() {
    abstract fun getDAO(): RestaurantsDAO
    abstract fun getFoodDao(): FoodDAO
    abstract fun getCartDao(): Cart
    abstract fun getHistory(): History

    companion object {
        @Volatile
        private var INSTANCE: RestaurantsDataBase? = null
        fun getInstance(context: Context): RestaurantsDataBase? {

            if (INSTANCE != null) {
                return INSTANCE
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantsDataBase::class.java,
                    "UserDataBAse"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}