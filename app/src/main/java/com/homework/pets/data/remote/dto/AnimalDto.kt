package com.homework.pets.data.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class AnimalDto(
    val id: Int,
    @SerializedName("_links")
    val links: LinksDto,
    val age: String,
    val attributes: AttributesDto,
    val breeds: BreedsDto,
    val coat: String,
    val colors: ColorsDto,
    val contact: ContactDto,
    val description: String,
    val distance: Double,
    val environment: EnvironmentDto,
    val gender: String,
    val name: String,
    @SerializedName("organization_id")
    val organizationId: String,
    val photos: List<PhotoDto>,
    @SerializedName("published_at")
    val publishedAt: String,
    val size: String,
    val species: String,
    val status: String,
    val tags: List<String>,
    val type: String,
    val url: String,
    val videos: List<VideoDto>
)