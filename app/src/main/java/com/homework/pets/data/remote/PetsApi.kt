package com.homework.pets.data.remote

import com.homework.pets.data.remote.dto.PetDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PetsApi {

    @GET("animals")
    suspend fun getPets(): Response<PetDto>

    @GET("animals/{id}")
    suspend fun getPet(@Path("id") id: Int)

}