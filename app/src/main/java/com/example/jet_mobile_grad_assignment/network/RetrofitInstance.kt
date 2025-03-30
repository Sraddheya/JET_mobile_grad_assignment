package com.example.jet_mobile_grad_assignment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://uk.api.just-eat.io/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val restaurantAPI: RestaurantAPI by lazy {
        retrofit.create(RestaurantAPI::class.java)
    }

}