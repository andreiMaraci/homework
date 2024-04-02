package com.homework.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.homework.common.ui.compose.ContentLoaderScreen
import com.homework.login.LoginViewModel

@Composable
fun  LoginScreen (
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
){

    val uiState by viewModel.state.collectAsState()
    ContentLoaderScreen(state = uiState.contentLoaderState) {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = { viewModel.onClickLogin() },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = "Login")
            }
        }
    }
}