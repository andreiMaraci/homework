package com.homework.pets.data.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class AttributesDto(
    val declawed: Boolean,
    @SerializedName("house_trained")
    val houseTrained: Boolean,
    @SerializedName("shots_current")
    val shotsCurrent: Boolean,
    @SerializedName("spayed_neutered")
    val spayedNeutered: Boolean,
    @SerializedName("special_needs")
    val specialNeeds: Boolean
)