package com.example.swiggy.mainActivityFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiggy.R
import com.example.swiggy.adopter.MartItemAdopter
import com.example.swiggy.databinding.FragmentInstamartBinding
import com.example.swiggy.model.MartItemModel


class Instamart : Fragment(), MartItemAdopter.AdapterCallback {
    private lateinit var list: ArrayList<MartItemModel>
    private lateinit var martBinding: FragmentInstamartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        martBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instamart, container, false)
        val window = requireActivity()!!.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor =
            requireActivity()!!.resources.getColor(com.example.swiggy.R.color.instamart_statusBar)
        list = ArrayList()
        martBinding.martItemRecycle.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        list.add(MartItemModel("0"))
        list.add(MartItemModel("0"))
        list.add(MartItemModel("0"))
        list.add(MartItemModel("0"))
        list.add(MartItemModel("0"))
        list.add(MartItemModel("0"))
        martBinding.martItemRecycle.adapter =
            MartItemAdopter(requireActivity(), list)
        martBinding.martItemRecycle.adapter!!.notifyDataSetChanged()
        val navController = NavHostFragment.findNavController(this)
        martBinding.userProfile.setOnClickListener {
            navController.navigate(com.example.swiggy.R.id.action_instamart2_to_orderRecords)

        }
        return martBinding.root

    }

    override fun onItemClicked(value: String) {
        Log.d("TAG", "onItemClicked: $value")
//        martBinding.setTotalItem.text = value
    }

}