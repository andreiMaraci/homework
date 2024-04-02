package com.homework.pets.data.remote.dto

import androidx.annotation.Keep


@Keep
data class ContactDto(
    val address: AddressDto,
    val email: String,
    val phone: String
)