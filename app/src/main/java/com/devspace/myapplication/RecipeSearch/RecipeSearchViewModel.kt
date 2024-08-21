package com.devspace.myapplication.RecipeSearch

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.devspace.myapplication.RecipeDetail.RecipeDetailService
import com.devspace.myapplication.RecipeDetail.RecipeDetailViewModel
import com.devspace.myapplication.RecipeList.SearchRecipeDto
import com.devspace.myapplication.common.RecipeService
import com.devspace.myapplication.common.RecipesDto
import com.devspace.myapplication.common.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeSearchViewModel {
}


