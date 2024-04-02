package com.homework.login.data

interface LoginDataSource {

    suspend fun getAccessToken()
}