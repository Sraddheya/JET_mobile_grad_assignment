package com.example.jet_mobile_grad_assignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RestaurantViewModelFactory(private val restaurantRepository: RestaurantRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RestaurantViewModel(restaurantRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}