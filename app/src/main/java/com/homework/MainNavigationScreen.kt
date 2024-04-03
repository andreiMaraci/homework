package com.homework

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.homework.login.ui.LoginScreen
import com.homework.pets.ui.petDetails.PetDetailsScreen
import com.homework.pets.ui.petList.PetListScreen

@Composable
fun MainNavigationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
               onLoginSuccess =  {
                   navController.navigate( "pet_list", )
               }
            )
        }

        composable( "pet_list" ) {
            PetListScreen(
                onPetClick = { id ->
                    navController.navigate(route = "pet_details/${id}", )
                }
            )
        }

        composable("pet_details/{animalId}") { backStackEntry ->
            val animalId = backStackEntry.arguments?.getString("animalId")?.toInt() ?: 0
            PetDetailsScreen(animalId)
        }
    }
}