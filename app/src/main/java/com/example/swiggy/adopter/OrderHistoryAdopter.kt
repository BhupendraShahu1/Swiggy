package com.example.swiggy.adopter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.swiggy.R
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.model.HistoryEntity

class OrderHistoryAdopter(val context: Context, val list: List<HistoryEntity>) :
    RecyclerView.Adapter<OrderHistoryAdopter.SetItem>() {
    var userViewModel: RestaurantModelView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetItem {
        return SetItem(
            LayoutInflater.from(context).inflate(R.layout.history_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SetItem, position: Int) {
        val model = list[position]
        holder.setDataItem(model, position)
        userViewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(context.applicationContext as Application)
                .create(RestaurantModelView::class.java)
    }

    inner class SetItem(itemView: View) : ViewHolder(itemView) {
        private val foodname: TextView = itemView.findViewById(R.id.CartItemFood_name)
        private val size: TextView = itemView.findViewById(R.id.size)
        private val count: TextView = itemView.findViewById(R.id.food_item_noCount)
        private val price: TextView = itemView.findViewById(R.id.totalItemPrice)
        fun setDataItem(model: HistoryEntity, position: Int) {
            foodname.text = model.foodType
            size.text = model.about
            count.text = model.itemCount.toString()
            price.text = model.totalPricer.toString()
        }
    }
}