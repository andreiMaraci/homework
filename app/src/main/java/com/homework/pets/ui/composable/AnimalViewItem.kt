package com.homework.pets.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.homework.pets.domain.model.Animal

@Composable
fun AnimalItemView(
    animal: Animal,
    clickOnAnimal: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                clickOnAnimal(animal.id)
            }.padding(8.dp)

    ) {
        Text(text = animal.name, maxLines = 1)

        Spacer(modifier = Modifier.weight(1f).fillMaxWidth())

        Text(text = animal.status, maxLines = 1)
    }
}

@Preview
@Composable
fun PreviewAnimalItemView() {
    AnimalItemView(
        animal = Animal(
            id = 0,
            age = "12",
            coat = null,
            description = " ",
            distance = 1.2,
            gender = "x",
            name = "Test",
            photos = listOf(),
            publishedAt = " ",
            size = " ",
            species = " ",
            status = "Active",
            type = " "
        )
    ) {}
}