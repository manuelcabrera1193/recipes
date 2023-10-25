/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cabrera.willard.domain.models.Recipe
import com.cabrera.willard.domain.usecase.GetRecipesUseCase
import com.cabrera.willard.recipes.navigation.UIEvents
import com.cabrera.willard.recipes.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    val useCase: GetRecipesUseCase,
) : ViewModel() {

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents>
        get() = _events

    private var _state = mutableStateOf(RecipeData())
    val state: State<RecipeData>
        get() = _state

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            _state.value = state.value.copy(currentState = UiState.LOADING)
            useCase().onSuccess { recipes ->
                _state.value = state.value.copy(
                    recipes = recipes,
                    currentState = UiState.from(recipes)
                )
            }.onFailure {
                _state.value = state.value.copy(currentState = UiState.ERROR)
            }
        }
    }

    fun goToDetail(recipe: Recipe?) {
        if (recipe == null) return
        viewModelScope.launch {
            _events.emit(UIEvents.GoDetail)
            _state.value = state.value.copy(selectedRecipe = recipe)
        }
    }

    fun goToMaps(recipe: Recipe?) {
        if (recipe == null) return
        viewModelScope.launch {
            _events.emit(UIEvents.GoMaps)
        }
    }
}
