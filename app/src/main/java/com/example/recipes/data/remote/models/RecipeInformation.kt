package com.example.recipes.data.remote.models

data class RecipeInformation(
    val id: Int,
    val title: String,
    val summary: String,
    val image: String,
    val readyInMinutes: Int,
    val sourceName: String,
    val glutenFree: Boolean,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val dishTypes: List<String>,
)