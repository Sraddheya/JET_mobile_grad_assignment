package com.example.jet_mobile_grad_assignment.api

import com.example.jet_mobile_grad_assignment.data.models.RestaurantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Responsible for the API endpoints and their request methods.
 */
interface RestaurantAPI {

    // GET request to get data from the API by passing in a postcode
    @GET("discovery/uk/restaurants/enriched/bypostcode/{postcode}")
    suspend fun getRestaurantResponseByPostcode(
        @Path("postcode") postcode: String
    ): Response<RestaurantResponse>

}