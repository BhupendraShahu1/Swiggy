package com.example.swiggy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OrderPlaced : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placed)

    }


    override fun onBackPressed() {
        super.onBackPressed()
        // If you want to navigate to AnotherActivity, replace AnotherActivity::class.java with your desired activity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        // Finish the current activity if you don't want to go back to it
        finish()
    }
}