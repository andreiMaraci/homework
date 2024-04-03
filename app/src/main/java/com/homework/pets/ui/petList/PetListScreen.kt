package com.homework.pets.ui.petList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.homework.common.ui.compose.ContentLoaderScreen
import com.homework.pets.ui.composable.AnimalItemView

@Composable
fun PetListScreen(
    onPetClick: (Int) -> Unit,
    viewModel: PetListScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()
    val state = rememberLazyListState()

    ContentLoaderScreen(state = uiState.contentLoaderState) {
        LazyColumn(
            state = state,
        ) {
            items(uiState.dataState){animal ->
                AnimalItemView(animal = animal) { id ->
                    onPetClick (id)
                }
            }
        }
    }

}