package com.example.jet_mobile_grad_assignment.data.models

data class Restaurant(
    val id: String,
    val name: String,
    val address: Address,
    val cuisines: List<Cuisine>,
    val rating: Rating

// Other fields are commented out because they are not used
//    val availability: Availability,
//    val deals: List<Deal>,
//    val defaultDisplayRank: Int,
//    val deliveryCost: Double,
//    val deliveryEtaMinutes: DeliveryEtaMinutes,
//    val deliveryOpeningTimeLocal: String,
//    val driveDistanceMeters: Int,
//    val isCollection: Boolean,
//    val isDelivery: Boolean,
//    val isNew: Boolean,
//    val isOpenNowForCollection: Boolean,
//    val isOpenNowForDelivery: Boolean,
//    val isOpenNowForPreorder: Boolean,
//    val isPremier: Boolean,
//    val isTemporarilyOffline: Boolean,
//    val isTemporaryBoost: Boolean,
//    val isTestRestaurant: Boolean,
//    val logoUrl: String,
//    val minimumDeliveryValue: Double,
//    val openingTimeLocal: String,
//    val tags: List<String>,
//    val uniqueName: String

)