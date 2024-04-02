package com.homework.login.data.remote

import com.homework.common.data.network.NetworkError
import com.homework.common.data.network.ResponseInterpreter
import com.homework.login.data.remote.dto.AuthDto
import javax.inject.Inject

class LoginRemoteData @Inject constructor(
    private val api: LoginApi,
    private val interpreter: ResponseInterpreter
) {

    suspend fun getAccessToken(): AuthDto{
        try {
            return interpreter.interpret(
                api.getAuthToken(
                    grantType = "client_credentials",
                    clientId = "8FvB92COL3loJkRHBozGPLOVKZTG4CgXal6Dou6EjsH5lj2SXB",
                    clientSecret = "zcYSA3CrhG6yW1dc539o8rAVgj7ecwLUaYHTSe3s"
                )
            )
        } catch (error: NetworkError) {
            throw error
        }
    }
}