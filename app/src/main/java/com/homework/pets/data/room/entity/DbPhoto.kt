package com.homework.pets.data.room.entity

import androidx.annotation.Keep


@Keep
data class DbPhoto(
    val full: String,
    val large: String,
    val medium: String,
    val small: String
)