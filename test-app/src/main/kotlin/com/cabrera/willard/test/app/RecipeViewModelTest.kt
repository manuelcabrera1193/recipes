/* Willard Cabrera - 2023 */
package com.cabrera.willard.test.app

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cabrera.willard.domain.fake.RecipeTestData
import com.cabrera.willard.domain.models.Recipe
import com.cabrera.willard.domain.repository.RecipeRepository
import com.cabrera.willard.domain.usecase.GetRecipesUseCase
import com.cabrera.willard.recipes.RecipeViewModel
import com.cabrera.willard.recipes.ui.state.UiState
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class RecipeViewModelTest {

    @Rule
    @JvmField
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun before() {
        hiltRule.inject()
    }

    @Test
    fun uiStateInitiallySuccess() = runTest {
        val useCase = GetRecipesUseCase(FakeRepository(), Dispatchers.Unconfined)
        val viewModel = RecipeViewModel(useCase)
        viewModel.getData()
        assert(viewModel.state.value.currentState != UiState.ERROR)
    }

    @Test
    fun uiStateInitially() = runTest {
        val useCase = GetRecipesUseCase(FakeRepository(), Dispatchers.Unconfined)
        val viewModel = RecipeViewModel(useCase)
        assert(viewModel.state.value.currentState != UiState.ERROR)
    }

    @Test
    fun uiStateInitiallyError() = runTest {
        val useCase = GetRecipesUseCase(FakeFailRepository(), Dispatchers.Unconfined)
        val viewModel = RecipeViewModel(useCase)
        viewModel.getData()
        assert(viewModel.state.value.currentState != UiState.SUCCESS)
    }
}

private class FakeRepository : RecipeRepository {
    override suspend fun fetchRecipes(): Result<List<Recipe>> {
        val list: List<Recipe> = listOf(RecipeTestData.create())
        return Result.success(list)
    }
}

private class FakeFailRepository : RecipeRepository {
    override suspend fun fetchRecipes(): Result<List<Recipe>> {
        return Result.failure(Exception())
    }
}
