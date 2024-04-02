package com.homework.pets.data.remote.dto

import androidx.annotation.Keep


@Keep
data class EnvironmentDto(
    val cats: Boolean,
    val children: Boolean,
    val dogs: Boolean
)