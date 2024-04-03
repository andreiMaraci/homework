package com.homework.pets.domain

import com.homework.pets.domain.model.Animal
import kotlinx.coroutines.flow.Flow

interface PetRepository {

    fun getAnimalsFlow() : Flow<List<Animal>>

    fun getAnimal(animalId: Int) : Animal

    suspend fun loadAnimals()
}