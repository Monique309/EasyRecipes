package com.devspace.myapplication.RecipeDetail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.devspace.myapplication.common.RecipeService
import com.devspace.myapplication.common.RecipesDto
import com.devspace.myapplication.common.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun RecipeDetailScreen(
    recipeId: String,
    navHostController: NavHostController,
    recipeDetailViewModel: RecipeDetailViewModel
) {

    val recipeDto by recipeDetailViewModel.uiGetRecipeInformation.collectAsState()
    recipeDetailViewModel.fetchGetRecipeInfo(recipeId)


    recipeDto?.let {

        Column(
            modifier = Modifier.fillMaxSize()

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navHostController.popBackStack()

                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = " Back Button")
                }
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = it.title
                )
            }

            RecipeDetailContent(it)

        }

    }
}



@Composable
fun RecipeDetailContent(recipe: RecipesDto) {
    Column (
        modifier = Modifier.fillMaxSize()

    ){
        AsyncImage(
            modifier = Modifier
                .height(200.dp)
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            model = recipe.image, contentDescription = "${recipe.title} Poster Image"
        )

        }


    }


