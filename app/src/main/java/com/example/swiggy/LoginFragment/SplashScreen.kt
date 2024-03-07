package com.example.swiggy.LoginFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.swiggy.R
import com.example.swiggy.databinding.FragmentSplaceScreenBinding


class SplashScreen : Fragment() {
    private lateinit var splashBinding: FragmentSplaceScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        splashBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_splace_screen, container, false)
        val navController = NavHostFragment.findNavController(this)
        splashBinding.getStarted.setOnClickListener {
            navController.navigate(R.id.action_splashScreen_to_loginNoFragment)
        }
        return splashBinding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//
//
    }
}