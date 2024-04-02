package com.homework.common.data.network

import com.homework.common.data.network.interpreter.NetworkResponseInterpreter
import com.homework.common.data.network.interpreter.ResponseInterpreter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideBaseUrl(): String = "https://api.petfinder.com/v2/"


    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideResponseInterpreter(): NetworkResponseInterpreter = ResponseInterpreter()
}