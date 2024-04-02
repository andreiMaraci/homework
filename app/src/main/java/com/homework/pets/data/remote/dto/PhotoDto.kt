package com.homework.pets.data.remote.dto

import androidx.annotation.Keep


@Keep
data class PhotoDto(
    val full: String,
    val large: String,
    val medium: String,
    val small: String
)