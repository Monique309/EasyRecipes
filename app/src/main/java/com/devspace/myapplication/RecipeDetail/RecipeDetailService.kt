package com.devspace.myapplication.RecipeDetail

import com.devspace.myapplication.common.RecipesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeDetailService {
    @GET("recipes/{id}/information?includeNutrition=false")
    suspend fun getRecipeInformation(@Path("id") id: String): Response<RecipesDto>
}