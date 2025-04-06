package com.example.jet_mobile_grad_assignment.repository

import com.example.jet_mobile_grad_assignment.api.RetrofitInstance
import com.example.jet_mobile_grad_assignment.data.models.RestaurantResponse
import retrofit2.Response

/**
 * The Repository class handles data operations.
 */
class RestaurantRepository {
    suspend fun getRestaurantsByPostcode(postcode: String): Response<RestaurantResponse> {
        return RetrofitInstance.restaurantAPI.getRestaurantResponse(postcode)
    }
}