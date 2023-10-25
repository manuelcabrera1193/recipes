/* Willard Cabrera - 2023 */
package com.cabrera.willard.domain.usecase

import com.cabrera.willard.domain.models.Recipe
import com.cabrera.willard.domain.repository.RecipeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository,
    @Named("DispatcherIO") val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): Result<List<Recipe>> {
        return withContext(dispatcher) { repository.fetchRecipes() }
    }
}
