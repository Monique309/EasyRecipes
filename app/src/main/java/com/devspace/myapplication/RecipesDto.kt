package com.devspace.myapplication

@kotlinx.serialization.Serializable

data class RecipesDto(
    val id: Int,
    val title: String,
    val image: String,
    val summary: String

)
