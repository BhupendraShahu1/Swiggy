package com.example.swiggy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    val cartId: Int?,
    val itemId: Int,
    val itemCount: Int,
    val totalPricer: Int,
    val actualPrice:Int,
    val foodType: String,
    val about: String
) {
    constructor(
        itemId: Int,
        itemCount: Int,
        totalPricer: Int,
        actualPrice: Int,
        foodType: String,
        about: String
    ) : this(
        null,
        itemId,
        itemCount,
        totalPricer,
        actualPrice,
        foodType,
        about
    )
}