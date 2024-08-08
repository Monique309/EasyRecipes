package com.devspace.myapplication

@kotlinx.serialization.Serializable

data class RecipesResponse(
    val recipes : List<RecipesDto>
)

