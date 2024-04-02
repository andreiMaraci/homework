package com.homework.login.data.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class AuthDto (
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: String,
    @SerializedName("access_token")
    val accessToken: String
)