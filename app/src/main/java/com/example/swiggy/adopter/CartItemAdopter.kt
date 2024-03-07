package com.example.swiggy.adopter

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.swiggy.R
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.model.CartEntity

class CartItemAdopter(val context: Context, val list: List<CartEntity>) :
    RecyclerView.Adapter<CartItemAdopter.setItem>() {
    var userViewModel: RestaurantModelView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): setItem {
        return setItem(
            LayoutInflater.from(context).inflate(R.layout.cart_multiple_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: setItem, position: Int) {
        val model = list[position]
        holder.setDataItem(model, position)
        userViewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(context.applicationContext as Application)
                .create(RestaurantModelView::class.java)
    }

    inner class setItem(itemView: View) : ViewHolder(itemView) {
        private var countValue = 0;
        private var totalPrice = 0;
        private val foodName: TextView = itemView.findViewById(R.id.CartItemFood_name)
        private val size: TextView = itemView.findViewById(R.id.size)
        private val count: TextView = itemView.findViewById(R.id.food_item_noCount)
        private val price: TextView = itemView.findViewById(R.id.totalItemPrice)
        private val subtract: ImageView = itemView.findViewById(R.id.cart_item_subtract)
        private val addMultiple: ImageView = itemView.findViewById(R.id.cart_item_multipleAdd)
        fun setDataItem(model: CartEntity, position: Int) {
            foodName.text = model.foodType
            size.text = model.about
            count.text = model.itemCount.toString()
            price.text = model.totalPricer.toString()
            addMultipleItem(position)
            removeItem(position)


        }

        private fun removeItem(position: Int) {
            subtract.setOnClickListener {
                countValue = list[position].itemCount
                if (countValue > 1) {
                    countValue--
                    totalPrice = list[position].totalPricer - list[position].actualPrice
                    Log.d("TAG", "setDataItem: $countValue")
                    userViewModel?.updateCartCount(
                        context.applicationContext, list[position].itemId!!, countValue, totalPrice
                    )
                } else {
                    userViewModel?.deleteCartItem(context.applicationContext, list[position].itemId)
                }

            }
        }

        private fun addMultipleItem(position: Int) {
            addMultiple.setOnClickListener {
                countValue = list[position].itemCount

                countValue++
                totalPrice = list[position].totalPricer + list[position].actualPrice
                Log.d("TAG", "setDataItem: $countValue")
                userViewModel?.updateCartCount(
                    context.applicationContext, list[position].itemId!!, countValue, totalPrice
                )
            }
        }

    }


}