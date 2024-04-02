package com.homework.pets.domain

import com.homework.pets.domain.model.Animal
import kotlinx.coroutines.flow.Flow

interface PetRepository {

    fun getAnimalsFlow() : Flow<List<Animal>>

    suspend fun loadAnimals()
}