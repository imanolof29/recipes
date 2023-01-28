package com.example.recipes.data.mappers

import com.example.recipes.data.remote.models.Recipe
import com.example.recipes.data.remote.models.RecipeInformation
import com.example.recipes.domain.models.RecipeDomain
import com.example.recipes.domain.models.RecipeInformationDomain

fun Recipe.toDomain(): RecipeDomain {
    return RecipeDomain(
        id = this.id,
        title = this.title,
        image = this.image
    )
}

fun RecipeInformation.toDomain(): RecipeInformationDomain {
    return RecipeInformationDomain(
        id = this.id,
        summary = this.summary,
        title = this.title,
        image = this.image,
        readyInMinutes = this.readyInMinutes,
        sourceName = this.sourceName,
        glutenFree = this.glutenFree,
        vegan = this.vegan,
        vegetarian = this.vegetarian,
        dishTypes = this.dishTypes,
    )
}