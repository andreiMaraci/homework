package com.homework.login.data.caching

import android.content.SharedPreferences
import com.homework.common.data.shareprefs.ACCESS_TOKEN
import com.homework.login.data.LoginDataSource
import com.homework.login.data.remote.LoginRemoteData
import javax.inject.Inject

class CachingLoginDataSource @Inject constructor(
    private val loginRemoteData: LoginRemoteData,
    private val sharePrefs: SharedPreferences
) : LoginDataSource {

    override suspend fun getAccessToken() {
        loginRemoteData.getAccessToken().also { authDto ->  
            sharePrefs.edit()
                .putString(
                    ACCESS_TOKEN,
                    "${authDto.tokenType} ${ authDto.accessToken}"
                ).apply()
        }
    }

}