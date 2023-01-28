package com.example.recipes.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.recipes.domain.models.RecipeDomain

@Composable
fun RecipeItem(
    recipe: RecipeDomain,
    onRecipeClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.clickable{
                onRecipeClick()
            },
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(recipe.image)
                    .crossfade(true)
                    .build(),
                contentDescription = recipe.title
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                recipe.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}