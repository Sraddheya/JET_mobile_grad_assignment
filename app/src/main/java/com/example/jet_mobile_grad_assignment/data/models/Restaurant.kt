package com.example.jet_mobile_grad_assignment.data.models

/**
 * Data class representing a restaurant.
 *
 * Note that some fields, though present in the API response, are not used in the app and
 * are therefore not included.
 */
data class Restaurant(
    val id: String,
    val name: String,
    val address: Address,
    val cuisines: List<Cuisine>,
    val rating: Rating
)