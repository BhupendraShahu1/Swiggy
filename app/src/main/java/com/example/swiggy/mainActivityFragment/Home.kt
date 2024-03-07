package com.example.swiggy.mainActivityFragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.swiggy.databinding.FragmentHomeBinding


class Home : Fragment() {
    private val texts =
        arrayOf("'Milk'", "'Pizza'", "'Burger'", "'Orange'", "'Biryani'") // Add your texts here
    private var currentIndex = 0
    private val handler = Handler()
    lateinit var homeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = DataBindingUtil.inflate(
            inflater,
            com.example.swiggy.R.layout.fragment_home,
            container,
            false
        )
        val window = requireActivity()!!.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor =
            requireActivity()!!.resources.getColor(com.example.swiggy.R.color.white)


        val navController = NavHostFragment.findNavController(this)
        homeBinding.userProfile.setOnClickListener {
            navController.navigate(com.example.swiggy.R.id.action_home2_to_orderRecords)
        }
        homeBinding.gotoFood.setOnClickListener {
            navController.navigate(com.example.swiggy.R.id.action_home2_to_food2)

        }
        homeBinding.gotoMart.setOnClickListener {
            navController.navigate(com.example.swiggy.R.id.action_home2_to_instamart2)

        }
        homeBinding.gotoDineout.setOnClickListener {
            navController.navigate(com.example.swiggy.R.id.action_home2_to_dineout2)

        }
        homeBinding.gotoGenie.setOnClickListener {
            navController.navigate(com.example.swiggy.R.id.action_home2_to_genie)

        }

        // Set factory for TextSwitcher to create TextViews
        homeBinding.textSwitcher.setFactory {
            val textView = TextView(requireContext())
            textView
        }

        // Set initial text
        setText(texts[currentIndex])

        // Start text switching every 2 seconds
        startTextSwitching()
        return homeBinding.root
    }

    private fun setText(newText: String) {
        homeBinding.textSwitcher.setText(newText)
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