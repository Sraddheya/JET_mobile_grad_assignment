package com.example.jet_mobile_grad_assignment.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.AsyncListDiffer
import com.example.jet_mobile_grad_assignment.data.models.Restaurant
import android.view.LayoutInflater
import android.widget.TextView
import com.example.jet_mobile_grad_assignment.R

class RestaurantAdapter (var restaurants: List<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){

    // ViewHolder class to hold the data to be displayed in the RecyclerView
    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvAddress: TextView = itemView.findViewById(R.id.tvAddress)
        val tvCuisine: TextView = itemView.findViewById(R.id.tvCuisine)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
    }

    // DiffUtil used to calculate the difference between two lists of restaurants
    private val differCallBack = object : DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallBack)

    // Creates ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    // Binds the data to the ViewHolder
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = differ.currentList[position]
        holder.tvName.text = restaurant.name
        holder.tvAddress.text = restaurant.address.toString()
        holder.tvCuisine.text = restaurant.cuisines.joinToString(separator = ", ") { it.name }
        holder.tvRating.text = restaurant.rating.starRating.toString()
    }

    // Returns the number of items in the list
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    // Submits a new list to the adapter (for difUtil to calculate the difference)
    fun submitList(list: List<Restaurant>) {
        differ.submitList(list)
    }

}