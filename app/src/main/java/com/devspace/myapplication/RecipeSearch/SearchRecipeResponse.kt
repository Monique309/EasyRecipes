package com.devspace.myapplication.RecipeSearch

import com.devspace.myapplication.RecipeList.SearchRecipeDto

data class SearchRecipeResponse(
    val results : List<SearchRecipeDto>

)
data class SearchRecipeDto(
    val id: Int,
    val title: String,
    val image: String
)
