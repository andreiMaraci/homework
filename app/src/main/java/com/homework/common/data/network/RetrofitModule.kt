package com.homework.common.data.network

import android.content.SharedPreferences
import com.homework.common.data.shareprefs.ACCESS_TOKEN
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideBaseUrl(): String = "https://api.petfinder.com/v2/"

    @Provides
    @Singleton
    fun provideClient(sharePrefs: SharedPreferences): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(
            Interceptor { chain ->
                chain.run {
                    proceed(
                        request().newBuilder()
                            .addHeader(
                                "Authorization",
                                sharePrefs.getString(ACCESS_TOKEN, null) ?: ""
                            ).build()
                    )
                }
            }
        ).addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        ).build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}