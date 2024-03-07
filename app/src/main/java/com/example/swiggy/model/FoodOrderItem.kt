package com.example.swiggy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FoodItem")
data class FoodOrderItem(
    @PrimaryKey(autoGenerate = true)
    val foodId: Int?,

    val bestSeller: String,
    val foodName: String,
    val price: Int,
    val rating: String,
    val about: String,
    val itemNo: Int,
    val tableAId: Long,
) {
    constructor(
        bestSeller: String,
        foodName: String,
        price: Int,
        rating: String,
        about: String,
        itemNo: Int,
        tableAId: Long
    ) : this(null, bestSeller, foodName, price, rating, about, itemNo, tableAId)
}
