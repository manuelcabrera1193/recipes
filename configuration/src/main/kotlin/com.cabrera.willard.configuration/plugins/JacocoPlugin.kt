/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.plugins

import com.cabrera.willard.configuration.configs.JacocoConfig
import org.gradle.api.Plugin
import org.gradle.api.Project

class JacocoPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.allprojects {
            JacocoConfig.apply(this)
        }
    }
}
