package com.homework.login.domain.usecase

import com.homework.common.domain.UseCaseResult
import com.homework.login.domain.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val repository: LoginRepository
) {

    @Suppress("USELESS_CAST")
    operator fun invoke(): Flow<UseCaseResult<Unit>> {
        return flow {
            emit(repository.getAccessToken())
        }.map {
            UseCaseResult.Success(Unit) as UseCaseResult<Unit>
        }.onStart {
            emit(UseCaseResult.Loading())
        }.catch {
            emit(UseCaseResult.Error())
        }
    }

}