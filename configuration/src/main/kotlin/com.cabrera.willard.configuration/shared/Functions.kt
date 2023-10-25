/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.shared

import org.gradle.api.Project

object Functions {
    fun applyCommonPlugins(project: Project) {
        project.plugins.apply("org.jlleitschuh.gradle.ktlint")
        project.plugins.apply("io.gitlab.arturbosch.detekt")
        project.plugins.apply("com.diffplug.spotless")
    }
}
