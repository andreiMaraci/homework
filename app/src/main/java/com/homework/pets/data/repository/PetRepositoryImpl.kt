package com.homework.pets.data.repository

import com.homework.pets.data.PetDataSource
import com.homework.pets.data.toDomain
import com.homework.pets.domain.PetRepository
import com.homework.pets.domain.model.Animal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PetRepositoryImpl(
    private val petDataSource: PetDataSource
): PetRepository {

    override fun getAnimalsFlow(): Flow<List<Animal>> {
        return petDataSource.getAnimalsFlow().map { list ->
            list.map { it.toDomain() }
        }
    }

    override fun getAnimal(animalId: Int): Animal {
        return  petDataSource.getAnimal(animalId).toDomain()
    }

    override suspend fun loadAnimals() {
        petDataSource.loadAnimals()
    }
}