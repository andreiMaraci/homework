package com.homework.pets.data.remote.dto

import androidx.annotation.Keep


@Keep
data class BreedsDto(
    val mixed: Boolean,
    val primary: String,
    val secondary: String?,
    val unknown: Boolean
)