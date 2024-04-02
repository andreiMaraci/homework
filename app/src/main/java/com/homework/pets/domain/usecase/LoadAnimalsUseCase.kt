package com.homework.pets.domain.usecase

import com.homework.common.domain.UseCaseResult
import com.homework.pets.domain.PetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class LoadAnimalsUseCase @Inject constructor(
    private val repository: PetRepository
) {

    @Suppress("USELESS_CAST")
    operator fun invoke(): Flow<UseCaseResult<Unit>> {
        return flow {
            emit(repository.loadAnimals())
        }.map {
            UseCaseResult.Success(Unit) as UseCaseResult<Unit>
        }.onStart {
            emit(UseCaseResult.Loading())
        }.catch {
            emit(UseCaseResult.Error())
        }
    }
}