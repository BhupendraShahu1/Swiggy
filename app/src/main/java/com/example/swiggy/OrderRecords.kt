package com.example.swiggy

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.adopter.CartItemAdopter
import com.example.swiggy.adopter.OrderHistoryAdopter
import com.example.swiggy.databinding.ActivityOrderRecordsBinding

class OrderRecords : AppCompatActivity() {
    private lateinit var historyBinding: ActivityOrderRecordsBinding
    private val modelView: RestaurantModelView by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        historyBinding = DataBindingUtil.setContentView(this, R.layout.activity_order_records)
        historyBinding.orderRecordsRecycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        modelView.getAllHistoryData(this)?.observe(this, Observer {
            historyBinding.orderRecordsRecycle.adapter = OrderHistoryAdopter(this, it)
        })
    }
}