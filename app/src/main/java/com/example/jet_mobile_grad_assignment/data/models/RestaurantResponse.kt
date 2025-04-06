package com.example.jet_mobile_grad_assignment.data.models

/**
 * Data class representing a the response from the RestaurantAPI call.
 *
 * Note that some fields, though present in the API response, are not used in the app and
 * are therefore not included.
 */
data class RestaurantResponse(
    val restaurants: List<Restaurant>
)