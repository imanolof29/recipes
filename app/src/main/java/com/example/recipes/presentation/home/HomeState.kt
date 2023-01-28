package com.example.recipes.presentation.home

import com.example.recipes.domain.models.RecipeDomain

data class HomeState(
    val recipes: List<RecipeDomain> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val message: String = ""
)