package com.example.recipes.data.repository

import com.example.recipes.data.mappers.toDomain
import com.example.recipes.data.remote.SpoonacularApi
import com.example.recipes.data.remote.models.RecipeInformation
import com.example.recipes.domain.models.RecipeDomain
import com.example.recipes.domain.models.RecipeInformationDomain
import com.example.recipes.domain.repository.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val api: SpoonacularApi
): RemoteRepository {

    override suspend fun getRecipes(): Result<List<RecipeDomain>> {
        return try {
            val response = api.getRecipes()
            Result.success(response.body()!!.recipes.map { it.toDomain() })
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getRecipeInformation(id: Int): Result<RecipeInformationDomain> {
        return try {
            val response = api.getRecipeInformation(id)
            Result.success(response.body()!!.toDomain())
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

}