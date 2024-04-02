package com.homework.pets.data.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.homework.pets.data.room.entity.DbPhoto

class PetTypeConverter {

    @TypeConverter
    fun fromAnimalPhotos(animalPhotos: List<DbPhoto>): String = Gson().toJson(animalPhotos)

    @TypeConverter
    fun toAnimalPhotos(value: String): List<DbPhoto> = Gson().fromJson(value, object :TypeToken<List<DbPhoto>>(){}.type)
}