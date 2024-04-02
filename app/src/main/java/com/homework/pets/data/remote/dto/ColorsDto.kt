package com.homework.pets.data.remote.dto

import androidx.annotation.Keep


@Keep
data class ColorsDto(
    val primary: String,
    val secondary: String?,
    val tertiary: String?
)