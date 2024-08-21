package com.devspace.myapplication.RecipeSearch

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeSearchService {
    @GET("/recipes/complexSearch?")
     fun searchRecipes(@Query("query")query: String): Call<SearchRecipeResponse>


}