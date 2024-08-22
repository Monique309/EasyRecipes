package com.devspace.myapplication.RecipeList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.devspace.myapplication.common.RecipesDto
import com.devspace.myapplication.common.designsystem.ERHtlmText

@Composable
fun RecipesListScreen(
    navController: NavHostController,
    viewModel: RecipeListViewModel
) {

    val randomRecipes by viewModel.randomRecipes.collectAsState()

    RecipesListContent(

        getRecipesList = randomRecipes

    )
    {itemClicked ->
        navController.navigate(route = "recipeDetail/${itemClicked.id}")

    }

}

@Composable
fun RecipesListContent(

    getRecipesList: List<RecipesDto>,
    onClick: (RecipesDto) -> Unit,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {

            Text(
                modifier = Modifier.padding(8.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                text = "EasyRecipes",


                )

            RecipesSession(
                label = "Popular Recipes",
                recipesList = getRecipesList,
                onClick = onClick


            )


        }

    }



    @Composable
    fun RecipesSession(
        label: String,
        recipesList: List<RecipesDto>,
        onClick: (RecipesDto) -> Unit

    ){


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(

                fontSize = 24.sp,
                text = label,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.size(8.dp))
            RecipesList(recipesList, onClick)
        }

    }

    @Composable
    private fun RecipesList(
        recipesList: List<RecipesDto>,
        onClick: (RecipesDto) -> Unit

    ) {
        LazyColumn {
            items(recipesList) {
                RecipeItem(
                    recipesDto = it,
                    onClick = onClick
                )
            }
        }
    }

    @Composable
    fun RecipeItem(
        recipesDto: RecipesDto,
        onClick: (RecipesDto) -> Unit

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    onClick.invoke(recipesDto)
                }
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
                    .fillMaxSize()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                model = recipesDto.image,
                contentDescription = "${recipesDto.title} Poster image"
            )
            Spacer(modifier = Modifier.size(8.dp))

            Text(
                modifier = Modifier.padding(8.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                text = recipesDto.title)


            ERHtlmText(
                text = recipesDto.summary, maxLine = 3,

                )
        }
    }


@Preview(showBackground = true)
@Composable
private fun RecipeListScreenPreview() {


    
    
}





