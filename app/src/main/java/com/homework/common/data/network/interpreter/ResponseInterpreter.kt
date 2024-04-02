package com.homework.common.data.network.interpreter

import com.homework.common.data.network.NetworkError
import retrofit2.Response

class ResponseInterpreter: NetworkResponseInterpreter {

    override fun <T> interpret(response: Response<T>): T {
        return  if (response.isSuccessful) {
                    response.body() ?: throw  NetworkError(errorMessage = "Body is null")
        } else {
            throw NetworkError(errorMessage = response.message())
        }

    }

}