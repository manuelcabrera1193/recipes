/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes.ui.state

data class MutableUiStateHolder(override var currentState: UiState = UiState.INIT) : UiStateHolder
