/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes.navigation

import androidx.core.util.Function
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cabrera.willard.domain.models.Recipe
import com.cabrera.willard.recipes.RecipeData
import com.cabrera.willard.recipes.ui.screens.detail.DetailScreen
import com.cabrera.willard.recipes.ui.screens.home.HomeScreen
import com.cabrera.willard.recipes.ui.screens.maps.MapsScreen

fun NavGraphBuilder.graph(
    state: () -> RecipeData,
    goToDetail: Function<Recipe?, Unit>,
    goToMaps: Function<Recipe?, Unit>,
) {
    navigation(
        startDestination = NavigationScreen.HomeScreen.screen,
        route = NavigationHost.InitNavHost.route
    ) {
        composable(NavigationScreen.HomeScreen.screen) {
            HomeScreen(state, goToDetail)
        }
        composable(NavigationScreen.DetailScreen.screen) {
            DetailScreen(state().selectedRecipe, goToMaps)
        }
        composable(NavigationScreen.MapsScreen.screen) {
            MapsScreen(state().selectedRecipe)
        }
    }
}
