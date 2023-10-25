/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.configs

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

object SpotlessConfig {
    fun apply(target: Project) {

        target.configure<SpotlessExtension> {
            kotlin {
                target("**/*.kt")
                ktlint()
                licenseHeader("/* Willard Cabrera - 2023 */")
            }
            kotlinGradle {
                target("**/*.gradle.kts")
                ktlint()
            }
        }
    }
}
