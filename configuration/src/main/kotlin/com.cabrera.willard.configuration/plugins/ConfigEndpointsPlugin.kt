/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.plugins

import com.android.build.gradle.BaseExtension
import com.cabrera.willard.configuration.constants.AndroidBuildConfig
import com.cabrera.willard.configuration.constants.BuildTypeCulqi
import com.cabrera.willard.configuration.constants.Variables.addLibraryVariables
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

class ConfigEndpointsPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            setupEndpoints()
        }
    }
    private fun Project.setupEndpoints() {
        val androidExt = extensions["android"]
        if (androidExt is BaseExtension) {
            with(androidExt) {
                compileSdkVersion(AndroidBuildConfig.compileSdk)

                buildTypes.getByName(BuildTypeCulqi.Debug.value) {
                    addLibraryVariables(BuildTypeCulqi.Debug)
                }
                /*
                buildTypes.getByName(BuildTypeCulqi.UAT.value) {
                    addLibraryVariables(BuildTypeCulqi.UAT)
                }*/
                buildTypes.getByName(BuildTypeCulqi.Release.value) {
                    addLibraryVariables(BuildTypeCulqi.Release)
                }
            }
        }
    }
}
