package com.example.recipes.domain.usecase

import com.example.recipes.domain.models.RecipeInformationDomain
import com.example.recipes.domain.repository.RemoteRepository

class GetRecipeInformation(
    private val repository: RemoteRepository
) {
    suspend operator fun invoke(id: Int): Result<RecipeInformationDomain> = repository.getRecipeInformation(id)
}