package com.homework

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "pet_list") {
        composable( "pets_list" ) {
        }

        composable("pet_details") {

        }
    }
}