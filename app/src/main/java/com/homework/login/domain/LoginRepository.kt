package com.homework.login.domain

interface LoginRepository {

    suspend fun getAccessToken()

}