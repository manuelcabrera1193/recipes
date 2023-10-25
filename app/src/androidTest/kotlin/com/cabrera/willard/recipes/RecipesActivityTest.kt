/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class RecipesActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRecipesActivity() {
        composeTestRule.setContent {
            RecipesActivity()
        }
    }
}
