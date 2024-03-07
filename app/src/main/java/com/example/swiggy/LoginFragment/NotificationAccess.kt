package com.example.swiggy.LoginFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.swiggy.R
import com.example.swiggy.databinding.FragmentNotificationAccessBinding

class NotificationAccess : Fragment() {
    lateinit var notificationBinding: FragmentNotificationAccessBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        notificationBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_notification_access,
            container,
            false
        )
        val navController = NavHostFragment.findNavController(this)
        notificationBinding.allowNotification.setOnClickListener {
            navController.navigate(R.id.action_notificationAccess_to_mainActivity)
        }
        return notificationBinding.root
    }
}