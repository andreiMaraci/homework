package com.homework.pets.data.caching.entity

import androidx.annotation.Keep


@Keep
data class PhotoEntity(
    val full: String,
    val large: String,
    val medium: String,
    val small: String
)