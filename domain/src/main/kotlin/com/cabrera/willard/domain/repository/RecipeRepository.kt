/* Willard Cabrera - 2023 */
package com.cabrera.willard.domain.repository

import com.cabrera.willard.domain.models.Recipe

interface RecipeRepository {
    suspend fun fetchRecipes(): Result<List<Recipe>>
}
