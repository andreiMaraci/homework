package com.homework.pets.data.room.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.homework.pets.data.room.DB_PET_NAME


@Keep
@Entity(tableName = DB_PET_NAME)
data class DbAnimal(
    @PrimaryKey val id: Int,
    val age: String,
    val coat: String?,
    val description: String?,
    val distance: Double,
    val gender: String,
    val name: String,
    val photos: List<DbPhoto>,
    val publishedAt: String,
    val size: String,
    val species: String,
    val status: String,
    val type: String
)