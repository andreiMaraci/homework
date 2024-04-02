package com.homework.pets.domain.model

import androidx.annotation.Keep


@Keep
data class Photo(
    val full: String,
    val large: String,
    val medium: String,
    val small: String
)