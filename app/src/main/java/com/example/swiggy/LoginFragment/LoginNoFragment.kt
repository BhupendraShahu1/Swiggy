package com.example.swiggy.LoginFragment

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.swiggy.R
import com.example.swiggy.databinding.FragmentLoginNoFragmentBinding


class LoginNoFragment : Fragment() {
    private lateinit var loginNoBinding: FragmentLoginNoFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        loginNoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login_no_fragment, container, false)
        loginNoBinding.inputNo.requestFocus()
        loginNoBinding.inputNo.hint = "10 digit mobile number"
        val html = ("<font color=" + Color.BLACK + "><b><i><u>Terms of Service</u></i></b></font>")
        val html2 = ("<font color=" + Color.BLACK + "><b><i><u>privacy Policy</u></i></b></font>")
        loginNoBinding.privacy.text = Html.fromHtml("By clicking .I accept the $html and $html2")

        // Show the soft keyboard when the activity starts
//        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        val navController = NavHostFragment.findNavController(this)
        loginNoBinding.getStarted.setOnClickListener {
            navController.navigate(R.id.action_loginNoFragment_to_OTPVerification)
        }
        return loginNoBinding.root

    }
}