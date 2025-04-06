package com.example.jet_mobile_grad_assignment.data.models

/**
 * Data class representing the rating of a restaurant.
 *
 * Note that some fields, though present in the API response, are not used in the app and
 * are therefore not included.
 */
data class Rating(
    val count: Int,
    val starRating: Double,
    val userRating: Any
)