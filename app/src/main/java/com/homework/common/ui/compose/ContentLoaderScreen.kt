package com.homework.common.ui.compose

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.homework.common.ui.state.ContentLoaderState

@Composable
fun ContentLoaderScreen(
    modifier: Modifier = Modifier,
    state: ContentLoaderState,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(alignment = Alignment.Center).size(60.dp),
                    color = Color.DarkGray,
                    strokeWidth = 6.dp
                )
            }

            state.isError -> {
                Toast.makeText(LocalContext.current, "There was an network error", Toast.LENGTH_LONG).show()
                content()
            }

            else -> {
                content()
            }
        }
    }
}