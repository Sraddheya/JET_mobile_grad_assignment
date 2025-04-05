package com.example.jet_mobile_grad_assignment

import com.example.jet_mobile_grad_assignment.data.models.RestaurantResponse
import com.example.jet_mobile_grad_assignment.network.RetrofitInstance
import retrofit2.Response

/**
 * The Repository class handles data operations.
 */
class RestaurantRepository {
    suspend fun getRestaurantsByPostcode(postcode: String): Response<RestaurantResponse> {
        return RetrofitInstance.restaurantAPI.getRestaurantResponse(postcode)
    }
}