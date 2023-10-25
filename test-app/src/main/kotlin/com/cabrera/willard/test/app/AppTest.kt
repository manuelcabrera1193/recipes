/* Willard Cabrera - 2023 */
package com.cabrera.willard.test.app

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.cabrera.willard.recipes.RecipesActivity
import com.cabrera.willard.recipes.utils.TestsUtil
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AppTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<RecipesActivity>()

    @Test
    fun testInitHome() {
        composeTestRule.onNodeWithContentDescription(TestsUtil.homeScreen).assertExists()
    }
}
