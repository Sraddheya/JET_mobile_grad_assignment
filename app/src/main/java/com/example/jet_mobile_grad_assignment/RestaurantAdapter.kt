package com.example.jet_mobile_grad_assignment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jet_mobile_grad_assignment.databinding.ItemRestaurantBinding
import com.example.jet_mobile_grad_assignment.data.models.Restaurant

class RestaurantAdapter (var restaurants: List<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){

    inner class RestaurantViewHolder(val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root){
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var restaurantsList: List<Restaurant>
        get() = differ.currentList
        set(value) {differ.submitList(value)}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(ItemRestaurantBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.binding.apply{
            val restaurant = restaurants[position]
            tvName.text = restaurant.name
        }
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}