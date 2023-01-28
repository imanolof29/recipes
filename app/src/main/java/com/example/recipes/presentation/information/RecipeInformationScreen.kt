package com.example.recipes.presentation.information

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun RecipeInformationScreen(
    viewModel: RecipeInformationViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if(state.value.isError){
        Text(state.value.message)
    }

    if(state.value.isLoading){
        CircularProgressIndicator()
    }

    if(state.value.isSuccess) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(state.value.recipe?.image ?: "")
                    .crossfade(true)
                    .build(),
                contentDescription = state.value.recipe!!.title,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    state.value.recipe!!.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(state.value.recipe!!.summary)
                LazyRow {
                    items(state.value.recipe!!.dishTypes) {
                        Text(it)
                    }
                }

            }
        }
    }


}