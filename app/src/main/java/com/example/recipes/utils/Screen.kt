package com.example.recipes.utils

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Information: Screen("information")
}