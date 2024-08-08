package com.devspace.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

@kotlinx.serialization.Serializable

interface ApiService {
    @GET("recipes/random?number=10")
    fun getRandomRecipes(): Call<RecipesResponse>

    @GET("/recipes/complexSearch?")
    fun searchRecipes(@Query("query")query: String): Call<SearchRecipeResponse>

}