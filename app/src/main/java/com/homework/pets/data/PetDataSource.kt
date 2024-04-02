package com.homework.pets.data

import com.homework.pets.data.caching.entity.AnimalEntity
import kotlinx.coroutines.flow.Flow

interface PetDataSource {

    fun getAnimalsFlow(): Flow<List<AnimalEntity>>

    suspend fun loadAnimals()
}