package com.homework.pets.ui.petDetails

import androidx.lifecycle.ViewModel
import com.homework.common.ui.state.UiState
import com.homework.pets.domain.model.Animal
import com.homework.pets.domain.usecase.GetAnimalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PetDetailsViewModel @Inject constructor(
    private val getAnimalUseCase: GetAnimalUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(
        UiState(dataState = Animal())
    )

    val state: StateFlow<UiState<Animal>>
        get() = _state

    fun getAnimal(animalId: Int) {
        _state.update { uiState ->
            uiState.copy(dataState = getAnimalUseCase.invoke(animalId))
        }
    }
}