package com.homework.pets.data.remote.dto


import androidx.annotation.Keep

@Keep
data class AddressDto(
    val address1: String?,
    val address2: String?,
    val city: String,
    val country: String,
    val postcode: String,
    val state: String
)