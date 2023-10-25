/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes.ui.screens.detail

import androidx.compose.runtime.Composable
import androidx.core.util.Function
import com.cabrera.willard.domain.models.Recipe

@Composable
fun DetailScreen(
    recipe: Recipe?,
    goToMaps: Function<Recipe?, Unit>,
) {

    ErrorState(recipe == null)

    SuccessState(recipe != null, recipe, goToMaps)
}
