package com.devspace.myapplication.common

import com.devspace.myapplication.RecipeSearch.SearchRecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RecipeService {
    @GET("recipes/random?number=10")
   suspend fun getRandomRecipes(): Response<RecipesResponse>

}