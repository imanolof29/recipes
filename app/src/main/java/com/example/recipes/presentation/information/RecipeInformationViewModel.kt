package com.example.recipes.presentation.information

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.domain.usecase.GetRecipeInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeInformationViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getRecipeInformation: GetRecipeInformation
): ViewModel() {

    private val _state = mutableStateOf(RecipeInformationState())

    val state: State<RecipeInformationState> =_state

    init {
        _state.value = _state.value.copy(
            isLoading = true
        )
        val recipeId = savedStateHandle.get<Int>("recipeId")
        recipeId?.let {
            viewModelScope.launch {
                getRecipeInformation.invoke(it)
                    .onSuccess {
                        _state.value = _state.value.copy(
                            recipe = it,
                            isLoading = false,
                            isSuccess = true,
                        )
                    }
                    .onFailure {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            isError = true,
                            message = it.localizedMessage ?: "Ha ocurrido un error"
                        )
                    }
            }
        } ?: run {
            _state.value = _state.value.copy(
                isError = true,
                message = "El id es nulo"
            )
        }
    }

}