package com.example.jet_mobile_grad_assignment.data.models

/**
 * Data class representing the address of a restaurant.
 *
 * Note that some fields, though present in the API response, are not used in the app and
 * are therefore not included.
 */
data class Address(
    val city: String,
    val firstLine: String,
    val postalCode: String
)

    // Clearer string representation of an Address object
{
    override fun toString(): String {
        return "$firstLine, $city, $postalCode"
    }
}