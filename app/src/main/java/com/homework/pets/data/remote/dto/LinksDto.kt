package com.homework.pets.data.remote.dto

import androidx.annotation.Keep


@Keep
data class LinksDto(
    val organization: OrganizationDto,
    val self: SelfDto,
    val type: TypeDto
)