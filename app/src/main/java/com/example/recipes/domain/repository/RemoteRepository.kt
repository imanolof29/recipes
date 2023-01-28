package com.example.recipes.domain.repository

import com.example.recipes.domain.models.RecipeDomain
import com.example.recipes.domain.models.RecipeInformationDomain

interface RemoteRepository {

    suspend fun getRecipes(): Result<List<RecipeDomain>>

    suspend fun getRecipeInformation(id: Int): Result<RecipeInformationDomain>

}