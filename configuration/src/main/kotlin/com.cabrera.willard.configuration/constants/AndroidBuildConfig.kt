/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.constants

object AndroidBuildConfig {
    const val composeVersion = "1.4.3"
    const val compileSdk = 34
    const val targetSdk = 33
    const val minSdk = 24
    const val basePackage = "com.cabrera.willard"
    const val applicationId = "com.cabrera.willard.recipes"
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "com.cabrera.willard.domain.HiltTestRunner"
    const val requiresOptIn = "-Xopt-in=kotlin.RequiresOptIn"
}
