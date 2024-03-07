package com.example.swiggy.adopter

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.swiggy.FoodOrder
import com.example.swiggy.R
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.model.Restaurants

class RestaurantsAdopter(
    val context: Context, val list: ArrayList<Restaurants>
) : RecyclerView.Adapter<RestaurantsAdopter.SetItem>() {
    private lateinit var navController: NavController
    var userViewModel: RestaurantModelView? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetItem {
        return SetItem(
            LayoutInflater.from(context).inflate(R.layout.food_restaurants_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SetItem, position: Int) {
        val model = this.list[position]
        holder.setData(model)
        holder.linearClick.setOnClickListener {
            userViewModel =
                ViewModelProvider.AndroidViewModelFactory.getInstance(context.applicationContext as Application)
                    .create(RestaurantModelView::class.java)
            userViewModel!!.getAllFoodData(context.applicationContext)
            val id = list.get(position).id
            if (id != null) {
                val intent = Intent(context.applicationContext, FoodOrder::class.java)
                intent.putExtra("key_data", id)
                context.startActivity(intent)
            }
        }
    }
    class SetItem(itemView: View) : ViewHolder(itemView) {
        val linearClick: LinearLayout = itemView.findViewById(R.id.restaurant_parentLayout)
        val restaurantsName: TextView = itemView.findViewById(R.id.id_restaurant_name)
        val rating: TextView = itemView.findViewById(R.id.id_rating_time)
        val distance: TextView = itemView.findViewById(R.id.id_distance)
        val foodType: TextView = itemView.findViewById(R.id.id_food_type)
        val image: ImageView = itemView.findViewById(R.id.item_image)

        fun setData(model: Restaurants) {
            restaurantsName.text = model.shopName
            rating.text = model.timeRating
            distance.text = model.distance
            foodType.text = model.typeOfFood
            if (model.shopImage == 1) {
                image.setImageResource(R.drawable.f4)
            } else if (model.shopImage == 2) {
                image.setImageResource(R.drawable.fast_food)
            } else if (model.shopImage == 3) {
                image.setImageResource(R.drawable.berger_img)
            } else if (model.shopImage == 4) {
                image.setImageResource(R.drawable.fast_food2)
            }
        }
    }
}


