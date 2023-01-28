package com.example.recipes.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.domain.usecase.GetRecipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRecipes: GetRecipes
): ViewModel() {

    private val _state = mutableStateOf(HomeState())

    val state: State<HomeState> =_state

    init{
        viewModelScope.launch {
            try{
                _state.value = _state.value.copy(
                    isLoading = true
                )
                getRecipes.invoke()
                    .onSuccess {recipeList ->
                        _state.value = _state.value.copy(
                            isLoading = false,
                            isSuccess = true,
                            recipes = recipeList,
                        )
                    }
                    .onFailure {error ->
                        _state.value = _state.value.copy(
                            isLoading = false,
                            isError = true,
                            message = error.message ?: "Ha habido un error"
                        )
                    }
            }catch (e: Exception) {
                _state.value = _state.value.copy(
                    isError = true,
                    message = e.message ?: "Ha habido un error"
                )
            }
        }
    }

}