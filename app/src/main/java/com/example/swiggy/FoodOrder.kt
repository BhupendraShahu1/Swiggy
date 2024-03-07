package com.example.swiggy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.adopter.FoodOrderItemAdopter
import com.example.swiggy.databinding.ActivityFoodOrderBinding
import com.example.swiggy.method.InsertMethod
import com.example.swiggy.model.FoodOrderItem

class FoodOrder : AppCompatActivity(), FoodOrderItemAdopter.OnAddTaste {
    private val modelView: RestaurantModelView by viewModels()
    private lateinit var orderBinding: ActivityFoodOrderBinding
    private var countTotalItem = 0
    private var all = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orderBinding = DataBindingUtil.setContentView(this, R.layout.activity_food_order)
        orderBinding.martTotalItem.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
        modelView.getSumOfColumn(this)?.observe(this, Observer {
            orderBinding.setTotalItem.text = it.toString()
        })
        modelView.getPriceColumn(this)?.observe(this, Observer {
            orderBinding.setTotalRate.text = it.toString()
        })
        modelView.getAllCartData(this)?.observe(this, Observer {
            if (it.isEmpty()) {
                orderBinding.martTotalItem.visibility = View.GONE
            } else {
                orderBinding.martTotalItem.visibility = View.VISIBLE
            }
        })
        val receivedData = intent.getLongExtra("key_data", 0)

        modelView.getDataFromA(this, receivedData)?.observe(this, Observer {
            if (it.isEmpty()) {
                insertData()
            }
            orderBinding.orderItemRecycle.adapter = FoodOrderItemAdopter(
                this, it as ArrayList<FoodOrderItem>, this, FoodOrder()
            )
        })

        orderBinding.orderItemRecycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun insertData() {
        val foodData: ArrayList<FoodOrderItem> = InsertMethod.getAllInsertFoodData()
        modelView.insertFood(this, foodData)
    }

    override fun onItemClick(position: Int) {
        Log.d("TAG", "onItemClick: $position")
//            val sumOfColumn = modelView.getSuOfColumn(this@FoodOrder)
//            Log.d("TAG", "onItemClick: $sumOfColumn")
//            orderBinding.setTotalItem.text = sumOfColumn.toString()

    }

}