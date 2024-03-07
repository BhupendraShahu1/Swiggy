package com.example.swiggy.LoginFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.swiggy.R
import com.example.swiggy.databinding.FragmentOTPVerificationBinding


class OTPVerification : Fragment() {
    private lateinit var otpBinding: FragmentOTPVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        otpBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_o_t_p_verification,
            container,
            false
        )
        val navController = NavHostFragment.findNavController(this)
        otpBinding.verifyOTp.setOnClickListener {
            navController.navigate(R.id.action_OTPVerification_to_location)
        }
        return otpBinding.root

    }
}