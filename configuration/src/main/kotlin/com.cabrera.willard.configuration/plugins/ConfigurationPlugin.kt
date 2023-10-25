/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.plugins

import com.cabrera.willard.configuration.configs.DetektConfig
import com.cabrera.willard.configuration.configs.KtLintConfig
import com.cabrera.willard.configuration.configs.SpotlessConfig
import com.cabrera.willard.configuration.shared.Functions
import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigurationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.allprojects {
            Functions.applyCommonPlugins(this)
            KtLintConfig.apply(this)
            DetektConfig.apply(this)
            SpotlessConfig.apply(this)
        }
    }
}
