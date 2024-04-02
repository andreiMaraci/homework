package com.homework.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homework.common.domain.UseCaseResult
import com.homework.common.ui.state.ContentLoaderState
import com.homework.common.ui.state.UiState
import com.homework.login.domain.usecase.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val getAccessTokenUseCase: GetAccessTokenUseCase
): ViewModel() {
    private val _state = MutableStateFlow(UiState(Unit))

    val state: StateFlow<UiState<Unit>>
        get() = _state

    fun onClickLogin(){
        getAccessTokenUseCase().onEach { result ->
            _state.update { uiState ->
                if (result is UseCaseResult.Success) {

                }
                uiState.copy(contentLoaderState = ContentLoaderState().applyUseCase(result))
            }
        }.launchIn(viewModelScope)
    }
}