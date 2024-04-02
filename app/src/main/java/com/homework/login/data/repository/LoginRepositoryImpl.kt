package com.homework.login.data.repository

import com.homework.login.data.LoginDataSource
import com.homework.login.domain.LoginRepository

class LoginRepositoryImpl(private val loginDataSource: LoginDataSource) : LoginRepository {

    override suspend fun getAccessToken() {
        loginDataSource.getAccessToken()
    }

}