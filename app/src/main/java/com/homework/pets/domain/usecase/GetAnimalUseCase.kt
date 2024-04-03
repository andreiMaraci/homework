package com.homework.pets.domain.usecase

import com.homework.pets.domain.PetRepository
import javax.inject.Inject

class GetAnimalUseCase @Inject constructor(
    private val repository: PetRepository
) {
    operator fun invoke(idAnimal: Int) = repository.getAnimal(idAnimal)

}