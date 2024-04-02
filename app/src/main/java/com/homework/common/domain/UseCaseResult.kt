package com.homework.common.domain

sealed class UseCaseResult<T>(val data: T? = null) {

    class Success<T>(data: T? = null): UseCaseResult<T>(data)

    class Error<T>: UseCaseResult<T>()

    class Loading<T>: UseCaseResult<T>()
}