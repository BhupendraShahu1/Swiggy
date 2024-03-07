package com.example.swiggy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.adopter.CartItemAdopter
import com.example.swiggy.databinding.ActivityCartBinding
import com.example.swiggy.model.CartEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class CartActivity : AppCompatActivity() {
    private lateinit var cartBinding: ActivityCartBinding
    private val modelView: RestaurantModelView by viewModels()
    private var list = ArrayList<CartEntity>()
    private var tax = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cartBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        cartBinding.cartItemRecycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        modelView.getAllCartData(this)?.observe(this, Observer {
            cartBinding.cartItemRecycle.adapter = CartItemAdopter(this, it)
            if (it.isEmpty()) {
                cartBinding.mainRelativeLayout.visibility = View.GONE
                cartBinding.emptyCart.visibility = View.VISIBLE
                cartBinding.pickupOneItem.setOnClickListener {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            } else {
                cartBinding.mainRelativeLayout.visibility = View.VISIBLE
                cartBinding.emptyCart.visibility = View.GONE
            }
        })
        modelView.getPriceColumn(this)?.observe(this, Observer {
            if (it != null) {
                cartBinding.totalPrice.text = it.toString()
                tax = (it / 100) * 18
                cartBinding.gstCharge.text = tax.toString()
                cartBinding.totalPayPrice.text = (tax + it).toString()
                cartBinding.totalPayFinalPrice.text = (tax + it).toString()
            }
        })
        cartBinding.getStarted.setOnClickListener {
//            modelView.deleteCart(this)
            Toast.makeText(this, "Order is Placed", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, OrderPlaced::class.java))
            CoroutineScope(Dispatchers.IO).async {
                modelView.historyTable(this@CartActivity)
            }
            CoroutineScope(Dispatchers.IO).async {
                modelView.deleteCart(this@CartActivity)
            }
            finish()
        }

    }


}