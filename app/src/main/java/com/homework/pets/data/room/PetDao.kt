package com.homework.pets.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.homework.pets.data.room.entity.DbAnimal
import kotlinx.coroutines.flow.Flow

@Dao
interface PetDao {

    @Query("SELECT * FROM $DB_PET_NAME")
    fun getAllPets(): Flow<List<DbAnimal>>

    @Query("SELECT * FROM $DB_PET_NAME WHERE id = :animalId")
    fun getAnimals(animalId: Int): DbAnimal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertPets(animals: List<DbAnimal>)

    @Delete
    fun removePet(animal: DbAnimal)
}