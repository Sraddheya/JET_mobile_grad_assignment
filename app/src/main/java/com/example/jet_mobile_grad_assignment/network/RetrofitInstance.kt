package com.example.jet_mobile_grad_assignment.network

import com.example.jet_mobile_grad_assignment.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The RetrofitInstance object creates a singleton instance of Retrofit and provides
 * access to the RestaurantAPI interface.
 */
object RetrofitInstance {

    // Establishes the configurations for the Retrofit instance
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Creates an instance of the RestaurantAPI interface
    val restaurantAPI: RestaurantAPI by lazy {
        retrofit.create(RestaurantAPI::class.java)
    }

}