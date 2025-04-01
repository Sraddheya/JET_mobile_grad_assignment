package com.example.jet_mobile_grad_assignment.network

import com.example.jet_mobile_grad_assignment.data.models.RestaurantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantAPI {

    //https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/EH39JJ

    @GET("discovery/uk/restaurants/enriched/bypostcode/{postcode}")
    suspend fun getRestaurantResponse(
        @Path("postcode") postcode: String
    ): Response<RestaurantResponse>

}