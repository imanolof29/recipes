package com.example.recipes.presentation.information

import com.example.recipes.domain.models.RecipeInformationDomain

data class RecipeInformationState(
    val recipe: RecipeInformationDomain? = null,
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val message: String = ""
)