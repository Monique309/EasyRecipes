package com.devspace.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun EasyRecipesApp() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "recipeList") {

        composable(route = "recipeList") {

            RecipesListScreen(navController)
        }
        composable(
            route = "recipeDetail" + "/{itemId}",
            arguments = listOf(navArgument("itemId") {
                type = NavType.StringType
            })

        ) { navBackStackEntry ->
            val recipeId = requireNotNull(navBackStackEntry.arguments?.getString("itemId"))
            RecipeDetailScreen(recipeId, navController)


        }
    }
}