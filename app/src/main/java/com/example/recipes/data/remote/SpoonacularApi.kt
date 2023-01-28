package com.example.recipes.data.remote

import com.example.recipes.data.remote.models.RecipeInformation
import com.example.recipes.data.remote.models.RecipesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SpoonacularApi {

    @GET("complexSearch?apiKey=0021154e08664b3a9909a4edf320151d")
    suspend fun getRecipes(): Response<RecipesResponse>

    @GET("{id}/information?apiKey=0021154e08664b3a9909a4edf320151d")
    suspend fun getRecipeInformation(@Path("id") id: Int): Response<RecipeInformation>

}