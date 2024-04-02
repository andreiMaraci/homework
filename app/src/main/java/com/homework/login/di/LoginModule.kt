package com.homework.login.di

import android.content.SharedPreferences
import com.homework.login.data.LoginDataSource
import com.homework.login.data.caching.CachingLoginDataSource
import com.homework.login.data.remote.LoginApi
import com.homework.login.data.remote.LoginRemoteData
import com.homework.login.data.repository.LoginRepositoryImpl
import com.homework.login.domain.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Provides
    @Singleton
    fun provideLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginDataSource(
        loginRemoteData: LoginRemoteData,
        sharedPreferences: SharedPreferences
    ): LoginDataSource{
        return CachingLoginDataSource(loginRemoteData, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(loginDataSource: CachingLoginDataSource): LoginRepository {
        return LoginRepositoryImpl(loginDataSource)
    }

}