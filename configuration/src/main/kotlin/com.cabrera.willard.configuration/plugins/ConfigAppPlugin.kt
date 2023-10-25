/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.plugins

import com.android.build.gradle.BaseExtension
import com.cabrera.willard.configuration.constants.AndroidBuildConfig
import com.cabrera.willard.configuration.constants.BuildTypeCulqi
import com.cabrera.willard.configuration.constants.Variables.addAppVariables
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class ConfigAppPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            setupGeneral()
            setupAndroid()
            setupKapt()
        }
    }

    private fun Project.setupGeneral() {
        plugins.apply("com.android.application")
        plugins.apply("org.jetbrains.kotlin.android")
        plugins.apply("com.google.dagger.hilt.android")
        plugins.apply("plugins.jacoco")

        tasks {
            withType(KotlinCompile::class.java) {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()
                    freeCompilerArgs = freeCompilerArgs + AndroidBuildConfig.requiresOptIn
                }
            }
        }
    }

    private fun Project.setupKapt() {
        plugins.apply("kotlin-kapt")
        val kaptExt = extensions["kapt"]

        if (kaptExt is KaptExtension) {
            with(kaptExt) {
                correctErrorTypes = true
            }
        }
    }

    private fun Project.setupAndroid() {
        val androidExt = extensions["android"]
        if (androidExt is BaseExtension) {
            with(androidExt) {
                namespace = AndroidBuildConfig.applicationId
                compileSdkVersion(AndroidBuildConfig.compileSdk)

                defaultConfig {
                    applicationId = AndroidBuildConfig.applicationId
                    minSdk = AndroidBuildConfig.minSdk
                    targetSdk = AndroidBuildConfig.targetSdk
                    versionCode = AndroidBuildConfig.versionCode
                    versionName = AndroidBuildConfig.versionName
                    testInstrumentationRunner = AndroidBuildConfig.testInstrumentationRunner
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                buildTypes.getByName(BuildTypeCulqi.Debug.value) {
                    applicationIdSuffix = ".${BuildTypeCulqi.Debug.value}"
                    addAppVariables(BuildTypeCulqi.Debug)
                }

                /*
                buildTypes.create(BuildTypeCulqi.UAT.value) {
                    initWith(buildTypes.getByName(BuildTypeCulqi.Debug.value))
                    applicationIdSuffix = ".${BuildTypeCulqi.UAT.value}"
                    addAppVariables(BuildTypeCulqi.UAT)
                }
                 */

                buildTypes.getByName(BuildTypeCulqi.Release.value) {
                    addAppVariables(BuildTypeCulqi.Release)
                    isDebuggable = false
                    isMinifyEnabled = true
                    setProguardFiles(
                        listOf(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-android.txt",
                            "proguard-rules.pro"
                        )
                    )
                }

                compileOptions {
                    targetCompatibility = JavaVersion.VERSION_17
                    sourceCompatibility = JavaVersion.VERSION_17
                }

                packagingOptions {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                        excludes += "/META-INF/**"
                    }
                }

                buildFeatures.buildConfig = true
                buildFeatures.compose = true
            }
        }
    }
}
