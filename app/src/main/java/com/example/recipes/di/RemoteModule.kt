package com.example.recipes.di

import com.example.recipes.data.remote.SpoonacularApi
import com.example.recipes.data.repository.RemoteRepositoryImpl
import com.example.recipes.domain.repository.RemoteRepository
import com.example.recipes.domain.usecase.GetRecipeInformation
import com.example.recipes.domain.usecase.GetRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideRemoteRepository(api: SpoonacularApi): RemoteRepository = RemoteRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideOKhttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideSpoonacularApi(okHttpClient: OkHttpClient): SpoonacularApi {
        return Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/recipes/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(SpoonacularApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGetRecipesUseCase(repository: RemoteRepositoryImpl) = GetRecipes(repository)

    @Provides
    @Singleton
    fun provideGetRecipeInformationUseCase(repository: RemoteRepositoryImpl) = GetRecipeInformation(repository)

}