package com.homework.pets.domain.usecase

import com.homework.pets.domain.PetRepository
import com.homework.pets.domain.model.Animal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimalsUseCase @Inject constructor(
    private val repository: PetRepository
) {

    operator fun invoke(): Flow<List<Animal>> = repository.getAnimalsFlow()

}