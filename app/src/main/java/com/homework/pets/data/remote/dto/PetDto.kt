package com.homework.pets.data.remote.dto

import androidx.annotation.Keep


@Keep
data class PetDto(
    val animals: List<AnimalDto>,
    val pagination: PaginationDto
)