package com.devspace.myapplication.RecipeDetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.devspace.myapplication.common.RecipesDto
import com.devspace.myapplication.common.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeDetailViewModel (
    private val recipeDetailService: RecipeDetailService): ViewModel(){

        private val _uiGetRecipeInformation = MutableStateFlow<RecipesDto?>(null)
    val uiGetRecipeInformation: StateFlow<RecipesDto?> = _uiGetRecipeInformation

    fun fetchGetRecipeInfo(recipeId: String) {
        if (_uiGetRecipeInformation.value == null) {
            viewModelScope.launch(Dispatchers.IO) {
                val response = recipeDetailService.getRecipeInformation(recipeId)
                if (response.isSuccessful) {
                    _uiGetRecipeInformation.value = response.body()!!
                } else {
                    Log.d("MovieDetailViewModel", "Request Error :: ${response.errorBody()}")
                }


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
                    val detailService =
                        RetrofitClient.retrofitInstance.create(RecipeDetailService::class.java)
                    return RecipeDetailViewModel(
                        detailService
                    ) as T
                }

            }
        }
    }
