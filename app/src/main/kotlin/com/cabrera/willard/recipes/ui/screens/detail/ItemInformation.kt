/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes.ui.screens.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cabrera.willard.domain.fake.RecipeTestData
import com.cabrera.willard.recipes.R
import com.cabrera.willard.recipes.ui.theme.detailDescriptionStyle
import com.cabrera.willard.recipes.utils.TestsUtil

@Composable
fun ItemInformation(value: String, imageVector: ImageVector) {
    Row(
        modifier = Modifier.clearAndSetSemantics {
            contentDescription = TestsUtil.itemInformation
        }
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = stringResource(id = R.string.icon_maps),
            modifier = Modifier.padding(12.dp),
        )
        Text(
            text = value,
            modifier = Modifier.padding(12.dp),
            style = detailDescriptionStyle,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ItemInformationPreview() {
    ItemInformation(RecipeTestData.description, Icons.Default.Favorite)
}
