package com.example.recipes.presentation.home


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material.Text
import com.example.recipes.domain.models.RecipeDomain
import com.example.recipes.presentation.home.components.RecipeItem

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onRecipeClick: (RecipeDomain) -> Unit
) {

    val state = viewModel.state

    if(state.value.isError){
        Text(state.value.message)
    }

    if(state.value.isLoading){
        CircularProgressIndicator()
    }

    if(state.value.isSuccess) {
        LazyColumn() {
            items(state.value.recipes) { recipe ->
                RecipeItem(recipe = recipe, onRecipeClick = { onRecipeClick(recipe) })
            }
        }
    }

}