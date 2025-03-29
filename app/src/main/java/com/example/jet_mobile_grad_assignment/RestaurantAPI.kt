package com.example.jet_mobile_grad_assignment

import com.example.jet_mobile_grad_assignment.data.models.RestaurantResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantAPI {

    @GET("discovery/uk/restaurants/enriched/bypostcode/EH39JJ")
    suspend fun getRestaurantResponse() : Response<RestaurantResponse>
}