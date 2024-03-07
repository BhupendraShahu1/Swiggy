package com.example.swiggy.adopter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.swiggy.R
import com.example.swiggy.model.MartItemModel

class MartItemAdopter(
    val context: Context,
    val list: ArrayList<MartItemModel>
) :
    RecyclerView.Adapter<MartItemAdopter.setItem>() {
    lateinit var adopterCall: AdapterCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): setItem {
        return setItem(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: setItem, position: Int) {
        val model = this.list[position]
        holder.setDAta(model)
    }

    inner class setItem(itemView: View) : ViewHolder(itemView) {

        var countValue = 0;
        val linearAdd: LinearLayout = itemView.findViewById(R.id.mart_item_notExpand)
        val linearExpand: LinearLayout = itemView.findViewById(R.id.mart_item_expand)
        val addItem: ImageView = itemView.findViewById(R.id.mart_item_add)
        val addMultiple: ImageView = itemView.findViewById(R.id.mart_item_multipleAdd)
        val removeItem: ImageView = itemView.findViewById(R.id.mart_item_subtract)
        val count: TextView = itemView.findViewById(R.id.mart_item_noCount)
        fun setDAta(model: MartItemModel) {
            addItem.setOnClickListener {

                countValue++
                count.text = countValue.toString()
                linearAdd.visibility = View.GONE
                linearExpand.visibility = View.VISIBLE

            }
            addMultiple.setOnClickListener {
                countValue++
                count.text = countValue.toString()
            }
            removeItem.setOnClickListener {

                if (countValue > 0) {
                    countValue--
                    count.text = countValue.toString()
                } else {
                    linearAdd.visibility = View.VISIBLE
                    linearExpand.visibility = View.GONE
                }
            }
        }

    }

    interface AdapterCallback {
        fun onItemClicked(value: String)
    }
}