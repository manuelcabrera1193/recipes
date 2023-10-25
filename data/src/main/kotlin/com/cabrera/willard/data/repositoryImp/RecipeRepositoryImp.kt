/* Willard Cabrera - 2023 */
package com.cabrera.willard.data.repositoryImp

import com.cabrera.willard.data.ApiService
import com.cabrera.willard.data.mapper.toModel
import com.cabrera.willard.data.utils.handleApiResponse
import com.cabrera.willard.domain.models.Recipe
import com.cabrera.willard.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImp @Inject constructor(
    private val apiService: ApiService,
) : RecipeRepository {
    override suspend fun fetchRecipes(): Result<List<Recipe>> {
        return handleApiResponse(
            apiCall = { apiService.fetchRecipes() },
            transform = { entities -> entities.map { it.toModel() } }
        )
    }
}
