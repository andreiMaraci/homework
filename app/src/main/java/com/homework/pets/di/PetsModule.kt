package com.homework.pets.di

import com.homework.pets.data.caching.CachingPetDataSource
import com.homework.pets.data.PetDataSource
import com.homework.pets.data.remote.PetRemoteData
import com.homework.pets.data.remote.PetsApi
import com.homework.common.data.db.AppDatabase
import com.homework.pets.data.repository.PetRepositoryImpl
import com.homework.pets.data.room.PetDao
import com.homework.pets.domain.PetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PetsModule {

    @Provides
    @Singleton
    fun providePetsApi(retrofit: Retrofit): PetsApi {
        return retrofit.create(PetsApi::class.java)
    }

    @Provides
    fun provideChannelDao(appDatabase: AppDatabase): PetDao {
        return appDatabase.petDao()
    }

    @Provides
    @Singleton
    fun providePetDataSource(petRemoteData: PetRemoteData, petDao: PetDao): PetDataSource{
        return CachingPetDataSource(petRemoteData, petDao)
    }

    @Provides
    @Singleton
    fun providePetRepository(petDataSource: PetDataSource): PetRepository{
        return PetRepositoryImpl(petDataSource)
    }
}