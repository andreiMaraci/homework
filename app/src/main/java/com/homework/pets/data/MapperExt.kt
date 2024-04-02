package com.homework.pets.data

import com.homework.pets.data.caching.entity.AnimalEntity
import com.homework.pets.data.caching.entity.PhotoEntity
import com.homework.pets.data.room.entity.DbAnimal
import com.homework.pets.data.room.entity.DbPhoto
import com.homework.pets.data.remote.dto.AnimalDto
import com.homework.pets.data.remote.dto.PhotoDto
import com.homework.pets.domain.model.Animal
import com.homework.pets.domain.model.Photo

//** === Room model to entity model === **//
fun DbAnimal.toEntity() = AnimalEntity(
    id = id,
    age = age,
    coat = coat,
    description = description,
    distance = distance,
    gender = gender,
    name = name,
    photos = photos.map { it.toEntity() },
    publishedAt = publishedAt,
    size = size,
    species = species,
    status = status,
    type = type
)

fun DbPhoto.toEntity() = PhotoEntity(
    full = full,
    large = large,
    medium = medium,
    small = small,
)

//** === Retrofit model to room model === **//
fun AnimalDto.toDb() = DbAnimal(
    id = id,
    age = age,
    coat = coat,
    description = description,
    distance = distance,
    gender = gender,
    name = name,
    photos = photos.map { it.toDb() },
    publishedAt = publishedAt,
    size = size,
    species = species,
    status = status,
    type = type
)

fun PhotoDto.toDb() = DbPhoto(
    full = full,
    large = large,
    medium = medium,
    small = small,
)

//** === Entity model to domain model === **//
fun AnimalEntity.toDomain() = Animal(
    id = id,
    age = age,
    coat = coat,
    description = description,
    distance = distance,
    gender = gender,
    name = name,
    photos = photos.map { it.toDomain() },
    publishedAt = publishedAt,
    size = size,
    species = species,
    status = status,
    type = type
)

fun PhotoEntity.toDomain() = Photo(
    full = full,
    large = large,
    medium = medium,
    small = small,
)
