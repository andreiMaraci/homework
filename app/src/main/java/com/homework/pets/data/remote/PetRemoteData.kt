package com.homework.pets.data.remote

import com.homework.common.data.network.NetworkError
import com.homework.common.data.network.interpreter.ResponseInterpreter
import com.homework.pets.data.remote.dto.PetDto
import javax.inject.Inject

class PetRemoteData @Inject constructor(
    private val api: PetsApi,
    private val interpreter: ResponseInterpreter
) {

    suspend fun getPet(): PetDto {
        try {
            return interpreter.interpret(api.getPets())
        } catch (error: NetworkError) {
            throw error
        }
    }

}