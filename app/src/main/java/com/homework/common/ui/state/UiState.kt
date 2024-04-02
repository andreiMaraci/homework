package com.homework.common.ui.state

import com.homework.common.domain.UseCaseResult


data class UiState<T>(
    val dataState: T,
    val contentLoaderState: ContentLoaderState = ContentLoaderState()

)

data class ContentLoaderState(
    val isLoading: Boolean = false,
    val isError: Boolean = false
) {
    fun applyUseCase(useCaseResult: UseCaseResult<*>): ContentLoaderState {
        return when (useCaseResult) {
            is UseCaseResult.Error -> this.copy(isLoading = false, isError = true)
            is UseCaseResult.Loading -> this.copy(isLoading = true, isError = false)
            is UseCaseResult.Success -> this.copy(isLoading = false, isError = false)
        }
    }
}
