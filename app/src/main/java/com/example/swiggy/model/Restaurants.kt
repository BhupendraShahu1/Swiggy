package com.example.swiggy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RestaurantsItem")
data class Restaurants(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,

    val shopImage: Int,
    val likeShop: Int,
    val offer: String,
    val purVeg: String,
    val option: Int,
    val timeRating: String,
    val typeOfFood: String,
    val distance: String,
    val deliveryType: String,
    val shopName: String
) {
    constructor(
        shopImage: Int,
        likeShop: Int,
        offer: String,
        purVeg: String,
        option: Int,
        timeRating: String,
        typeOfFood: String,
        distance: String,
        deliveryType: String,
        shopName: String
    ) : this(
        null,
        shopImage,
        likeShop,
        offer,
        purVeg,
        option,
        timeRating,
        typeOfFood,
        distance,
        deliveryType,
        shopName
    )
}