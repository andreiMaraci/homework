package com.homework.common.data.network

import retrofit2.Response
import javax.inject.Inject

class ResponseInterpreter @Inject constructor() {

    fun <T> interpret(response: Response<T>): T {
        return  if (response.isSuccessful) {
                    response.body() ?: throw  NetworkError(errorMessage = "Body is null")
        } else {
            throw NetworkError(errorMessage = response.message())
        }
    }

}