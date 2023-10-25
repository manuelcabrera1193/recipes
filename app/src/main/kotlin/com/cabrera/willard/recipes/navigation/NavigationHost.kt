/* Willard Cabrera - 2023 */
package com.cabrera.willard.recipes.navigation

sealed class NavigationHost(val route: String) {
    object InitNavHost : NavigationHost("navigation_host")
}
