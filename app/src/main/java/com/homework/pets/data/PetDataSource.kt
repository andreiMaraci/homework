package com.homework.pets.data

import com.homework.pets.data.caching.entity.AnimalEntity
import kotlinx.coroutines.flow.Flow

interface PetDataSource {

    fun getAnimalsFlow(): Flow<List<AnimalEntity>>

    fun getAnimal(animalId: Int): AnimalEntity

    suspend fun loadAnimals()
}