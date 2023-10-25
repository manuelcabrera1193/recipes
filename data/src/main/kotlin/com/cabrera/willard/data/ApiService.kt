/* Willard Cabrera - 2023 */
package com.cabrera.willard.data

import com.cabrera.willard.data.entities.RecipeEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(BuildConfig.get_recipes)
    suspend fun fetchRecipes(): Response<List<RecipeEntity>>
}
