package com.homework.common.data.shareprefs

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharePrefsModule {

    @Provides
    @Singleton
    fun provideSharePrefs(@ApplicationContext appContext: Context) : SharedPreferences {
       return appContext.getSharedPreferences("homework", Context.MODE_PRIVATE)
    }

}