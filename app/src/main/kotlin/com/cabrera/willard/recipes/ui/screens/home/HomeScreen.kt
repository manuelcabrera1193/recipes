/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.core.util.Function
import com.cabrera.willard.domain.models.Recipe
import com.cabrera.willard.recipes.RecipeData
import com.cabrera.willard.recipes.utils.TestsUtil

@Composable
fun HomeScreen(
    state: () -> RecipeData,
    goToDetail: Function<Recipe?, Unit>,
) {
    Column(
        modifier = Modifier.clearAndSetSemantics {
            contentDescription = TestsUtil.homeScreen
        }
    ) {
        TitleAppBar()

        ErrorState(state().isErrorVisible)

        LoadingState(state().isLoadingVisible)

        EmptyState(state().isEmptyVisible)

        SuccessState(state().isSuccessVisible, state().recipes, goToDetail)
    }
}
