/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes

import com.cabrera.willard.domain.models.Recipe
import com.cabrera.willard.recipes.ui.state.UiState
import com.cabrera.willard.recipes.ui.state.UiStateHolder

data class RecipeData(
    val recipes: List<Recipe> = emptyList(),
    val selectedRecipe: Recipe? = null,
    override var currentState: UiState = UiState.INIT,
) : UiStateHolder
