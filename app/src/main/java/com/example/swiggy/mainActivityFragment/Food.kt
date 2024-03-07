package com.example.swiggy.mainActivityFragment

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiggy.DataPassListener
import com.example.swiggy.R
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.adopter.RestaurantsAdopter
import com.example.swiggy.databinding.FragmentFoodBinding
import com.example.swiggy.method.InsertMethod
import com.example.swiggy.model.Restaurants


class Food : Fragment() {

    private lateinit var foodBinding: FragmentFoodBinding
    private val userViewModel: RestaurantModelView by viewModels()
    private var dataPassListener: DataPassListener? = null
    private val texts =
        arrayOf("'Milk'", "'Pizza'", "'Burger'", "'Orange'", "'Biryani'") // Add your texts here
    private var currentIndex = 0
    private val handler = Handler()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        foodBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_food, container, false)
        val navController = NavHostFragment.findNavController(this)
        foodBinding.userProfile.setOnClickListener {
            navController.navigate(com.example.swiggy.R.id.action_food2_to_orderRecords)

        }
        dataPassListener = activity as? DataPassListener

        userViewModel.getAllRestaurantsData(requireActivity())
            ?.observe(requireActivity(), Observer {
                if (it.isEmpty()) {
                    insertDAt()
                }
                foodBinding.restaurantRecycle.adapter =
                    RestaurantsAdopter(requireActivity(), it as ArrayList<Restaurants>)

            })
        val window = requireActivity()!!.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor =
            requireActivity()!!.resources.getColor(com.example.swiggy.R.color.extraWhite)

        val html = ("<font color=" + Color.BLACK + "><b>Enjoy</b></font>")
        val html2 = ("<font color=" + Color.RED + "><b>Free delivery & 50% OFF </b></font>")
        val html3 = ("<font color=" + Color.BLACK + "><b>On your first order </b></font>")
//        foodBinding.idOffer.text = html + html2 + html3
        foodBinding.idOffer.text = Html.fromHtml(html + html2 + html3)
        val spannableText =
            SpannableStringBuilder().bold { append("BHUPENDRA,") }.append(" what's on your mind? ")
        foodBinding.idYourMind.text = spannableText
        // Inflate the layout for this fragment
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = requireActivity().window
            window.statusBarColor =
                ContextCompat.getColor(requireContext(), com.example.swiggy.R.color.purple)
        }

        // Set factory for TextSwitcher to create TextViews
        foodBinding.textSwitcher.setFactory {
            val textView = TextView(requireContext())
            textView
        }

        // Set initial text
        setText(texts[currentIndex])

        // Start text switching every 2 seconds
        startTextSwitching()
        foodBinding.restaurantRecycle.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)


        return foodBinding.root
    }

    private fun insertDAt() {
        val restaurantData: ArrayList<Restaurants> = InsertMethod.getAllInsertRestaurantData()
        userViewModel.insertRestaurants(requireActivity(), restaurantData)
    }

    private fun setText(newText: String) {
        foodBinding.textSwitcher.setText(newText)
    }

    private fun startTextSwitching() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                // Switch to the next text
                currentIndex = (currentIndex + 1) % texts.size
                setText(texts[currentIndex])

                // Repeat every 2 seconds
                handler.postDelayed(this, 2000)
            }
        }, 2000)
    }

    override fun onDestroyView() {
        // Remove callbacks to avoid memory leaks
        handler.removeCallbacksAndMessages(null)
        super.onDestroyView()
    }

}