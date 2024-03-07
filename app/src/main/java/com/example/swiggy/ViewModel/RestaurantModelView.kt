package com.example.swiggy.ViewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.swiggy.model.CartEntity
import com.example.swiggy.model.FoodOrderItem
import com.example.swiggy.model.HistoryEntity
import com.example.swiggy.model.Restaurants
import com.example.swiggy.repository.RestaurantsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class RestaurantModelView(application: Application) : AndroidViewModel(application) {
    fun insertRestaurants(context: Context, user: List<Restaurants>) {
        RestaurantsRepository.insertRestaurants(context, user)
    }

    fun getAllRestaurantsData(context: Context): LiveData<List<Restaurants>>? {
        return RestaurantsRepository.getAllRestaurantsData(context)
    }

    fun getAllFoodData(context: Context): LiveData<List<FoodOrderItem>>? {
        return RestaurantsRepository.getAllFoodData(context)
    }

    fun getDataFromA(context: Context, id: Long): LiveData<List<FoodOrderItem>>? {
        return RestaurantsRepository.getDataByIdA(context, id)
    }

    fun insertFood(context: Context, user: List<FoodOrderItem>) {
        RestaurantsRepository.insertFood(context, user)
    }

    fun insertCartItem(context: Context, user: CartEntity) {
        RestaurantsRepository.insertCartItem(context, user)
    }

    fun updateCartCount(context: Context, itemId: Int, count: Int, totalPrice: Int) {
        RestaurantsRepository.updateCartCount(context, itemId, count, totalPrice)
    }

    suspend fun updateFoodCountItem(context: Context, id: Int, count: Int) {
        RestaurantsRepository.updateFoodCountItem(context, id, count)
    }

    fun getAllCartData(context: Context): LiveData<List<CartEntity>>? {
        return RestaurantsRepository.getAllCartData(context)
    }

    fun getAllHistoryData(context: Context): LiveData<List<HistoryEntity>>? {
        return RestaurantsRepository.getAllHistoryData(context)
    }

    fun getAllCartDataById(context: Context, id: Int): LiveData<List<CartEntity>>? {
        return RestaurantsRepository.getAllCartDataById(context, id)
    }

    fun deleteCartItem(context: Context, itemId: Int) {
        return RestaurantsRepository.deleteCartItem(context, itemId)
    }

    suspend fun deleteCart(context: Context) {
        return CoroutineScope(Dispatchers.IO).async {
            RestaurantsRepository.deleteCart(context)
        }.await()
    }

    suspend fun historyTable(context: Context) {
        return CoroutineScope(Dispatchers.IO).async {
            RestaurantsRepository.historyTable(context)
        }.await()
    }

    suspend fun isItemIdExists(context: Context, itemId: Int): Boolean? {
        return CoroutineScope(Dispatchers.IO).async {
            RestaurantsRepository.isItemIdExists(context, itemId)
        }.await()
    }

    fun getSumOfColumn(context: Context): LiveData<Int>? {
        return RestaurantsRepository.getSumOfColumn(context)
    }

    fun getPriceColumn(context: Context): LiveData<Int>? {
        return RestaurantsRepository.getPriceColumn(context)
    }
}