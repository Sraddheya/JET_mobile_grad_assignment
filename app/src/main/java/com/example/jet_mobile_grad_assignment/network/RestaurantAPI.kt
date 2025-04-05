package com.example.jet_mobile_grad_assignment.network

import com.example.jet_mobile_grad_assignment.data.models.RestaurantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * The RestaurantAPI interface defines the API endpoints and their request methods.
 */
interface RestaurantAPI {

    // GET request to get data from the API using a postcode
    @GET("discovery/uk/restaurants/enriched/bypostcode/{postcode}")
    suspend fun getRestaurantResponse(
        @Path("postcode") postcode: String
    ): Response<RestaurantResponse>

}