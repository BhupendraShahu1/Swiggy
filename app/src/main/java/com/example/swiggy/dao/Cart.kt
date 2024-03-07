package com.example.swiggy.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.swiggy.model.CartEntity

@Dao
interface Cart {
    @Insert
    fun insertCartItem(cartEntity: CartEntity)

    @Query("UPDATE cart SET itemCount = :itemCount,totalPricer=:totalPrice WHERE itemId = :itemId")
    suspend fun updateCartCount(itemId: Int, itemCount: Int, totalPrice: Int)

    @Query("SELECT * FROM  cart")
    fun getAllCartData(): LiveData<List<CartEntity>>

    @Query("DELETE FROM cart WHERE itemId = :itemId")
    fun deleteCartItem(itemId: Int)

    @Query("SELECT CASE WHEN EXISTS (SELECT 1 FROM cart WHERE itemId = :valueToCheck) THEN 1 ELSE 0 END")
    fun isDataPresent(valueToCheck: Int): Boolean

    @Query("SELECT SUM(itemCount)FROM cart")
    fun getSumOfColumn(): LiveData<Int>

    @Query("SELECT SUM(totalPricer) FROM cart")
    fun getPriceColumn(): LiveData<Int>

    @Query("select * from cart where itemId  = :itemID")
    fun getAllItemByRestaurantID(itemID: Int): LiveData<List<CartEntity>>

    @Query("DELETE FROM cart")
   suspend fun deleteCart()
}