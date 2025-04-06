package com.example.jet_mobile_grad_assignment.repository

import com.example.jet_mobile_grad_assignment.api.RetrofitInstance
import com.example.jet_mobile_grad_assignment.data.models.RestaurantResponse
import retrofit2.Response

/**
 * Responsible for getting restaurant data from the API.
 */
class RestaurantRepository {
    // Function to get restaurant data by passing in a postcode
    suspend fun getRestaurantResponse(postcode: String): Response<RestaurantResponse> {
        return RetrofitInstance.restaurantAPI.getRestaurantResponseByPostcode(postcode)
    }
}