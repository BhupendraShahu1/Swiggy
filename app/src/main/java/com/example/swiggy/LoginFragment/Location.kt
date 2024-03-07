package com.example.swiggy.LoginFragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.swiggy.R
import com.example.swiggy.databinding.FragmentLocationBinding

class Location : Fragment() {
    private lateinit var locationBinding: FragmentLocationBinding
    private val MY_PERMISSIONS_REQUEST_LOCATION = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        locationBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_location, container, false)
        val navController = NavHostFragment.findNavController(this)
        locationBinding.allowLocation.setOnClickListener {
            getLocation()
            navController.navigate(R.id.action_location_to_notificationAccess)

        }

        return locationBinding.root

    }

    private fun getLocation() {
        if (ContextCompat.checkSelfPermission(
                requireActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                MY_PERMISSIONS_REQUEST_LOCATION
            )
        } else {
            // Permission already granted
            // You can now proceed with location-related tasks
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                // Check if the permission is granted
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, proceed with location-related tasks

                } else {
                    // Permission denied, handle it (e.g., show a message or disable location-related features)
                }
            }

            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }
}