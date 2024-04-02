package com.homework.common.data.db

import android.content.Context
import android.util.Log
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "AppDataBase"
        ).allowMainThreadQueries()
            .setQueryCallback(
                { sqlQuery, bindArgs ->
                    Log.d("Boss", "SQL Query: $sqlQuery SQL Args: $bindArgs")
                },
                Executors.newSingleThreadExecutor()
            )
            .fallbackToDestructiveMigration()
            .build()
    }
}