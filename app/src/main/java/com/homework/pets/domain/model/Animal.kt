package com.homework.pets.domain.model

import androidx.annotation.Keep


@Keep
data class Animal(
    val id: Int,
    val age: String,
    val coat: String,
    val description: String,
    val distance: Double,
    val gender: String,
    val name: String,
    val photos: List<Photo>,
    val publishedAt: String,
    val size: String,
    val species: String,
    val status: String,
    val type: String
)