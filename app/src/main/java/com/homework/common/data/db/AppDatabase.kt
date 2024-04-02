package com.homework.common.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.homework.pets.data.room.PetDao
import com.homework.pets.data.room.PetTypeConverter
import com.homework.pets.data.room.entity.DbAnimal

@Database(entities = [DbAnimal::class], version = 1)
@TypeConverters(PetTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun petDao() : PetDao
}