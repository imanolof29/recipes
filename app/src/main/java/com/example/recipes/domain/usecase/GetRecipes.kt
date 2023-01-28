package com.example.recipes.domain.usecase

import com.example.recipes.domain.models.RecipeDomain
import com.example.recipes.domain.repository.RemoteRepository

class GetRecipes(
    private val repository: RemoteRepository
) {

    suspend operator fun invoke(): Result<List<RecipeDomain>> = repository.getRecipes()

}