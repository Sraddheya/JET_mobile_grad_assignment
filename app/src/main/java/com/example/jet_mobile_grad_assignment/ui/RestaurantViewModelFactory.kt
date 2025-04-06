package com.example.jet_mobile_grad_assignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jet_mobile_grad_assignment.repository.RestaurantRepository

/*
 * The RestaurantViewModelFactory is a factory class for creating instances of RestaurantViewModel.
 */
class RestaurantViewModelFactory(private val restaurantRepository: RestaurantRepository) : ViewModelProvider.Factory {

    // Creates an instance of RestaurantViewModel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RestaurantViewModel(restaurantRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}