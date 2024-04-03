package com.homework.pets.ui.petDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.homework.R
import com.homework.common.ui.compose.ContentLoaderScreen
import com.homework.pets.domain.model.Animal

@Composable
fun PetDetailsScreen(
    animalId: Int,
    viewModel: PetDetailsViewModel = hiltViewModel()
) {

    val uiState by viewModel.state.collectAsState()
    viewModel.getAnimal(animalId)

    ContentLoaderScreen(state = uiState.contentLoaderState) {
        PetDetailsContent(animal = uiState.dataState)
    }
}

@Composable
fun PetDetailsContent(animal: Animal) {
    val state = rememberLazyListState()
    val context = LocalContext.current

    Column {
        InfoLine(name = context.getString(R.string.name), description = animal.name)
        InfoLine(name = context.getString(R.string.status), description = animal.status)
        InfoLine(name = context.getString(R.string.size), description = animal.size)
        InfoLine(name = context.getString(R.string.gender), description = animal.gender)
        InfoLine(
            name = context.getString(R.string.distance),
            description = animal.distance.toString()
        )
        InfoLine(name = context.getString(R.string.species), description = animal.species)
        InfoLine(name = context.getString(R.string.type), description = animal.type)
        InfoLine(name = context.getString(R.string.age), description = animal.age)

        if (animal.description != null) {
            Text(
                text = animal.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

        if (animal.photos.isNotEmpty()) {
            LazyRow(state = state) {
                items(animal.photos) {
                    AsyncImage(
                        modifier = Modifier.padding(8.dp),
                        model = it.large,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun InfoLine(name: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Text(text = name, maxLines = 1)

        Spacer(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        Text(text = description, maxLines = 1)
    }
}