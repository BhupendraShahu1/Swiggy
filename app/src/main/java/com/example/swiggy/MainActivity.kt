package com.example.swiggy

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val userViewModel: RestaurantModelView by viewModels()
    private lateinit var navController: NavController
    private lateinit var activityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        userViewModel.insert(this, Restaurants(1, 12, "no", "yes", 122, "123.3", "VEG", "3km", "Free", "RAMA"))
//        bh.addRestro(Restaurants())
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainFragmentContainer) as NavHostFragment
        navController = navHostFragment.navController
//        activityBinding.bottomNavigation.setupWithNavController(navController)
        activityBinding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_id -> {
                    navController.navigate(R.id.home2)
                    true
                }

                R.id.food_id -> {
                    navController.navigate(R.id.food2)
                    true
                }

                R.id.mart_id -> {
                    navController.navigate(R.id.instamart2)
                    true
                }

                R.id.dineot_id -> {
                    navController.navigate(R.id.dineout2)
                    true
                }

                R.id.genie_id -> {
                    navController.navigate(R.id.genie)
                    true
                }

                else -> false
            }
        }
    }
//    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
//        if (!navController.navigateUp()) {
//            super.onBackPressedDispatcher
//        }
//    }


}