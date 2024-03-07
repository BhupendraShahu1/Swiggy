package com.example.swiggy.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.swiggy.dataBase.RestaurantsDataBase
import com.example.swiggy.model.CartEntity
import com.example.swiggy.model.FoodOrderItem
import com.example.swiggy.model.HistoryEntity
import com.example.swiggy.model.Restaurants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class RestaurantsRepository {
    companion object {
        private var userDatabase: RestaurantsDataBase? = null
        private fun initializeRepository(context: Context): RestaurantsDataBase? {
            return RestaurantsDataBase.getInstance(context)
        }

        fun insertRestaurants(context: Context, user: List<Restaurants>) {
            userDatabase = initializeRepository(context)
            CoroutineScope(Dispatchers.IO).launch {
                userDatabase?.getDAO()?.insertData(user)
            }
        }

        fun getAllRestaurantsData(context: Context): LiveData<List<Restaurants>>? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getDAO()?.getAllRestaurantsData()
        }

        fun insertFood(context: Context, user: List<FoodOrderItem>) {
            userDatabase = initializeRepository(context)
            CoroutineScope(Dispatchers.IO).launch {
                userDatabase?.getFoodDao()?.insertData(user)
            }
        }

        fun getAllFoodData(context: Context): LiveData<List<FoodOrderItem>>? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getFoodDao()?.getAllFoodData()
        }

        fun getAllCartData(context: Context): LiveData<List<CartEntity>>? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getCartDao()?.getAllCartData()
        }

        fun getAllHistoryData(context: Context): LiveData<List<HistoryEntity>>? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getHistory()?.getAllHistoryData()
        }

        fun getAllCartDataById(context: Context, id: Int): LiveData<List<CartEntity>>? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getCartDao()?.getAllItemByRestaurantID(id)
        }

        fun getDataByIdA(context: Context, id: Long): LiveData<List<FoodOrderItem>>? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getFoodDao()?.getItemsRelatedToTableA(id)
        }

        fun updateCartCount(context: Context, id: Int, count: Int, totalPrice: Int) {
            userDatabase = initializeRepository(context)
            CoroutineScope(Dispatchers.IO).launch {
                userDatabase?.getCartDao()?.updateCartCount(id, count, totalPrice)
            }

        }

        suspend fun updateFoodCountItem(context: Context, id: Int, count: Int) {
            userDatabase = initializeRepository(context)
            CoroutineScope(Dispatchers.IO).async {
                userDatabase?.getFoodDao()?.updateFoodCountItem(id, count)
            }

        }

        fun insertCartItem(context: Context, user: CartEntity) {
            userDatabase = initializeRepository(context)
            CoroutineScope(Dispatchers.IO).launch {
                userDatabase?.getCartDao()?.insertCartItem(user)
            }

        }

        fun deleteCartItem(context: Context, itemId: Int) {
            userDatabase = initializeRepository(context)
            CoroutineScope(Dispatchers.IO).launch {
                userDatabase?.getCartDao()?.deleteCartItem(itemId)
            }
        }

        suspend fun deleteCart(context: Context) {
            userDatabase = initializeRepository(context)
            userDatabase?.getCartDao()?.deleteCart()
        }

        suspend fun historyTable(context: Context) {
            userDatabase = initializeRepository(context)
            userDatabase?.getHistory()?.historyTable()
        }

        fun isItemIdExists(context: Context, itemId: Int): Boolean? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getCartDao()?.isDataPresent(itemId)
        }

        fun getSumOfColumn(context: Context): LiveData<Int>? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getCartDao()?.getSumOfColumn()
        }

        fun getPriceColumn(context: Context): LiveData<Int>? {
            userDatabase = initializeRepository(context)
            return userDatabase?.getCartDao()?.getPriceColumn()
        }
    }
}
