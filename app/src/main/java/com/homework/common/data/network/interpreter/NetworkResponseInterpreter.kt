package com.homework.common.data.network.interpreter

import retrofit2.Response

interface NetworkResponseInterpreter {
    fun<T> interpret(response: Response<T>): T
}