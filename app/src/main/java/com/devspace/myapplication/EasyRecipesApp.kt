package com.devspace.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devspace.myapplication.RecipeDetail.RecipeDetailScreen
import com.devspace.myapplication.RecipeDetail.RecipeDetailViewModel
import com.devspace.myapplication.RecipeList.RecipeListViewModel
import com.devspace.myapplication.RecipeList.RecipesListScreen

@Composable
fun EasyRecipesApp(
    recipeListViewModel: RecipeListViewModel,
    recipeDetailViewModel: RecipeDetailViewModel
) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "recipeList") {

        composable(route = "recipeList") {

            RecipesListScreen(navController,recipeListViewModel, recipeDetailViewModel)
        }
        composable(
            route = "recipeDetail" + "/{itemId}",
            arguments = listOf(navArgument("itemId") {
                type = NavType.StringType
            })

        ) { navBackStackEntry ->
            val recipeId = requireNotNull(navBackStackEntry.arguments?.getString("itemId"))
            RecipeDetailScreen(recipeId, navController,recipeDetailViewModel)


        }
    }
}