package com.homework.pets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homework.common.ui.state.ContentLoaderState
import com.homework.common.ui.state.UiState
import com.homework.pets.domain.model.Animal
import com.homework.pets.domain.usecase.GetAnimalsUseCase
import com.homework.pets.domain.usecase.LoadAnimalsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PetViewModel @Inject constructor(
    private val loadAnimalsUseCase: LoadAnimalsUseCase,
    private val getAnimalsUseCase: GetAnimalsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(
        UiState(
            dataState = listOf<Animal>()
        )
    )

    val state: StateFlow<UiState<List<Animal>>>
        get() = _state

    init {
        collectData()
        loadData()
    }

    private fun collectData() {
        getAnimalsUseCase().onEach { result ->
            _state.update { uiState ->
                uiState.copy(dataState = result)
            }
        }.launchIn(viewModelScope)
    }

    private fun loadData() {
        loadAnimalsUseCase().onEach { result ->
            _state.update { uiState ->
                uiState.copy(contentLoaderState = ContentLoaderState().applyUseCase(result))
            }
        }.launchIn(viewModelScope)
    }
}