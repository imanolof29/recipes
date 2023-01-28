package com.example.recipes.data.remote.models

import com.google.gson.annotations.SerializedName


data class RecipesResponse(
    @SerializedName("results")
    val recipes: List<Recipe>
)