package com.example.swiggy.adopter

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.swiggy.R
import com.example.swiggy.ViewModel.RestaurantModelView
import com.example.swiggy.model.CartEntity
import com.example.swiggy.model.FoodOrderItem
import com.ms.square.android.expandabletextview.ExpandableTextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class FoodOrderItemAdopter(
    val context: Context, val list: ArrayList<FoodOrderItem>,

    private val lifecycleOwner: LifecycleOwner, private val onItemAddClick: OnAddTaste
) : RecyclerView.Adapter<FoodOrderItemAdopter.setItem>() {
    var userViewModel: RestaurantModelView? = null
    var countNo = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): setItem {
        return setItem(LayoutInflater.from(context).inflate(R.layout.add_item_order, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: setItem, position: Int) {
        val model = this.list[position]
        holder.setData(model, position)
        userViewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(context.applicationContext as Application)
                .create(RestaurantModelView::class.java)
        userViewModel?.getAllCartDataById(context.applicationContext, list[position].foodId!!)
            ?.observe(lifecycleOwner, Observer {
                for (entity in it) {
                    countNo = entity.itemCount
                    Log.d("TAG", "onBindViewHolder:${entity.itemCount}")
                    holder.noCount.text = entity.itemCount.toString()
                    if (countNo > 0) {
                        holder.addItem.visibility = View.GONE
                        holder.expandView.visibility = View.VISIBLE
                    }
                }
            })
        holder.addItem.setOnClickListener {
            insertCart(position)
            holder.addItem.visibility = View.GONE
            holder.expandView.visibility = View.VISIBLE
        }
    }

    inner class setItem(itemView: View) : ViewHolder(itemView) {
        private var price = 0;
        val expandView: CardView = itemView.findViewById(R.id.food_item_expand)
        private val expandTExtView: ExpandableTextView =
            itemView.findViewById(R.id.expand_text_view)
        val addItem: CardView = itemView.findViewById(R.id.add_item)
        val addMultiple: ImageView = itemView.findViewById(R.id.food_item_multipleAdd)
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        val noCount: TextView = itemView.findViewById(R.id.food_item_noCount_f)
        val nameofItem: TextView = itemView.findViewById(R.id.id_restaurant_name)
        val priceRate: TextView = itemView.findViewById(R.id.id_price)
        val rating: TextView = itemView.findViewById(R.id.id_ratting)
        val removeItem: ImageView = itemView.findViewById(R.id.food_item_subtract)


        fun setData(model: FoodOrderItem, position: Int) {
            expandTExtView.text = model.about
            nameofItem.text = model.foodName
            priceRate.text = model.price.toString()
            rating.text = model.rating
            addMultipleItemBtn(position)
            subtractMultipleItemBtn(position)
            if (model.foodId == 1) {
                itemImage.setImageResource(R.drawable.f4)
            } else if (model.foodId == 2) {
                itemImage.setImageResource(R.drawable.f3)
            } else if (model.foodId == 3) {
                itemImage.setImageResource(R.drawable.fast_food)
            } else if (model.foodId == 4) {
                itemImage.setImageResource(R.drawable.fast_food2)
            } else if (model.foodId == 5) {
                itemImage.setImageResource(R.drawable.ff3)
            } else if (model.foodId == 6) {
                itemImage.setImageResource(R.drawable.f4)
            } else if (model.foodId == 7) {
                itemImage.setImageResource(R.drawable.berger_img)
            } else if (model.foodId == 8) {
                itemImage.setImageResource(R.drawable.f3)
            } else if (model.foodId == 9) {
                itemImage.setImageResource(R.drawable.fast_food)
            } else if (model.foodId == 10) {
                itemImage.setImageResource(R.drawable.fast_food2)
            } else if (model.foodId == 11) {
                itemImage.setImageResource(R.drawable.ff3)
            } else if (model.foodId == 12) {
                itemImage.setImageResource(R.drawable.berger_img)
            } else {
                itemImage.setImageResource(R.drawable.f4)
            }

        }

        private fun subtractMultipleItemBtn(position: Int) {
            removeItem.setOnClickListener {

                if (countNo > 1) {
                    countNo--
                    onItemAddClick.onItemClick(countNo)
                    price = countNo * list[position].price
                    userViewModel?.updateCartCount(
                        context, list[position].foodId!!, countNo, price
                    )
                } else {
                    userViewModel?.deleteCartItem(
                        context.applicationContext, list[position].foodId!!
                    )
                    addItem.visibility = View.VISIBLE
                    expandView.visibility = View.GONE

                }
            }
        }

        private fun addMultipleItemBtn(position: Int) {
            addMultiple.setOnClickListener {
                countNo++
                onItemAddClick.onItemClick(countNo)
                price = countNo * list[position].price
                userViewModel?.updateCartCount(context, list[position].foodId!!, countNo, price)
            }
        }
    }


    interface OnAddTaste {
        fun onItemClick(count: Int)
    }

    private fun insertCart(position: Int) {
        CoroutineScope(Dispatchers.IO).async {
            val itemIdExists = userViewModel?.isItemIdExists(
                context.applicationContext, list[position].foodId!!
            )
            if (itemIdExists == false) {
                userViewModel?.insertCartItem(
                    context.applicationContext, CartEntity(
                        list[position].foodId!!,
                        1,
                        list[position].price,
                        list[position].price,
                        list[position].foodName,
                        list[position].about
                    )
                )
            }
        }
    }
}