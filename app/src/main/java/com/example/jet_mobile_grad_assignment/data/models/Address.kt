package com.example.jet_mobile_grad_assignment.data.models

data class Address(
    val city: String,
    val firstLine: String,
    val postalCode: String

// Other fields are commented out because they are not used
//  val location: Location,
)

    // Clearer string representation of an Address object
{
    override fun toString(): String {
        return "$firstLine, $city, $postalCode"
    }
}