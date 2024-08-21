package com.devspace.myapplication.RecipeList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.devspace.myapplication.common.RecipeService
import com.devspace.myapplication.common.RecipesDto
import com.devspace.myapplication.common.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers


class RecipeListViewModel (
private val recipeService: RecipeService): ViewModel() {

    private val _randomRecipes = MutableStateFlow<List<RecipesDto>>(emptyList())
    val randomRecipes: StateFlow<List<RecipesDto>> = _randomRecipes

    init {
        fetchRandomRecipes()

    }

    private fun fetchRandomRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = recipeService.getRandomRecipes()

            if (response.isSuccessful) {
                val recipes = response.body()?.recipes
                if (recipes != null) {
                    _randomRecipes.value = recipes
                }

            } else {
                Log.d("RecipeListViewModel", "Request Error :: ${response.errorBody()}")
            }

        }

    }
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val recipeService =
                    RetrofitClient.retrofitInstance.create(RecipeService::class.java)
                return RecipeListViewModel(
                    recipeService

                ) as T
            }
        }
    }
}


