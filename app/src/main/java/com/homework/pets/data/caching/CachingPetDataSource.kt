package com.homework.pets.data.caching

import android.util.Log
import com.homework.pets.data.PetDataSource
import com.homework.pets.data.caching.entity.AnimalEntity
import com.homework.pets.data.remote.PetRemoteData
import com.homework.pets.data.room.PetDao
import com.homework.pets.data.toDb
import com.homework.pets.data.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CachingPetDataSource @Inject constructor(
    private val petRemoteData: PetRemoteData,
    private val petDataBase: PetDao
) : PetDataSource {

    override fun getAnimalsFlow(): Flow<List<AnimalEntity>> {
        return petDataBase.getAllPets().map { animals ->
            animals.map { it.toEntity()  }
        }
    }

    override fun getAnimal(animalId: Int): AnimalEntity {
        return petDataBase.getAnimals(animalId).toEntity()
    }

    override suspend fun loadAnimals() {
        petRemoteData.getPet().also { pet ->
            try {
                petDataBase.insertPets(pet.animals.map { it.toDb() })
            } catch (e: Exception){
                Log.d("Boss", e.message.toString())
            }
        }
    }

}