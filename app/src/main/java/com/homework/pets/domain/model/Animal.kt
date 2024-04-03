package com.homework.pets.domain.model

import androidx.annotation.Keep


@Keep
data class Animal(
    val id: Int = -1,
    val age: String = "",
    val coat: String? = "",
    val description: String? = "",
    val distance: Double = 0.0,
    val gender: String = "",
    val name: String = "",
    val photos: List<Photo> = listOf(),
    val publishedAt: String = "",
    val size: String = "",
    val species: String = "",
    val status: String = "",
    val type: String = ""
)