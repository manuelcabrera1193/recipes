/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.constants

import com.cabrera.willard.configuration.constants.Versions.activityComposeVersion
import com.cabrera.willard.configuration.constants.Versions.appCompatVersion
import com.cabrera.willard.configuration.constants.Versions.composeVersion
import com.cabrera.willard.configuration.constants.Versions.constraintLayoutVersion
import com.cabrera.willard.configuration.constants.Versions.coreEspressoVersion
import com.cabrera.willard.configuration.constants.Versions.coreKtxVersion
import com.cabrera.willard.configuration.constants.Versions.junitExtVersion
import com.cabrera.willard.configuration.constants.Versions.junitVersion
import com.cabrera.willard.configuration.constants.Versions.lifecycleRuntimeVersion
import com.cabrera.willard.configuration.constants.Versions.material3Version
import com.cabrera.willard.configuration.constants.Versions.materialVersion
import com.cabrera.willard.configuration.constants.Versions.uiMaterialVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val uiCompose = "androidx.compose.ui:ui:$composeVersion"
    const val uiComposePreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val uiTestCompose = "androidx.compose.ui:ui-test-junit4:$composeVersion"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val uiManifest = "androidx.compose.ui:ui-test-manifest:$composeVersion"
    const val uiMaterial = "androidx.compose.material:material:$uiMaterialVersion"
    const val uiMaterial3 = "androidx.compose.material3:material3:$material3Version"
    const val uiConstraint = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    const val uiMaterial3windows =
        "androidx.compose.material3:material3-window-size-class:$material3Version"

    const val accompanist = "com.google.accompanist:accompanist-pager:0.27.1"

    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    const val material = "com.google.android.material:material:$materialVersion"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeVersion"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    const val dataBinding = "androidx.databinding:databinding-runtime:${Versions.dataBinding}"

    // COMPOSE
    const val composeNavigation = "androidx.navigation:navigation-compose:2.5.3"
    const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
    const val COMPOSE_MATERIAL_COMPOSE_ICONS_EXTENDED =
        "androidx.compose.material:material-icons-extended:$composeVersion"
    const val COMPOSE_UI = "androidx.compose.ui:ui:$composeVersion"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:$composeVersion"
    const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val COMPOSE_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:1.0.0"

    // Coroutines
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"

    // Dagger - Hilt
    const val HILT = "com.google.dagger:hilt-android:2.44"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:2.44"
    const val HILT_VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:1.0.0"
    const val COMPOSE_HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:1.0.0"

    // Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:4.9.3"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:4.9.3"
    const val mockserver = "com.squareup.okhttp3:mockwebserver:5.0.0-alpha.10"

    // Room
    const val ROOM = "androidx.room:room-ktx:2.4.2"
    const val ROOM_COMPILER = "androidx.room:room-compiler:2.4.2"

    // Firebase
    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:30.1.0"
    const val FIREBASE_UI_AUTH = "com.firebaseui:firebase-ui-auth:8.0.1"
    const val PLAY_SERVICES_AUTH = "com.google.android.gms:play-services-auth:20.2.0"
    const val FIREBASE_AUTH = "com.google.firebase:firebase-auth:21.0.6"
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics-ktx"
    const val FIREBASE_PERFORMANCE = "com.google.firebase:firebase-perf-ktx"

    // CIL IMAGE
    const val COIL = "io.coil-kt:coil:2.1.0"
    const val COIL_COMPOSE = "io.coil-kt:coil-compose:2.1.0"
    const val COIL_GIF = "io.coil-kt:coil-gif:2.1.0"

    const val IMAGE_CROPPER = "com.github.CanHub:Android-Image-Cropper:4.3.0"

    // TEST
    const val junit = "junit:junit:$junitVersion"
    const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
    const val coreEspresso = "androidx.test.espresso:espresso-core:$coreEspressoVersion"

    // Mock
    const val mock = "org.mock-server:mockserver-netty:5.3.0"

    // Lottie
    const val lottie = "com.airbnb.android:lottie-compose:5.2.0"

    // Signature
    const val signature = "se.warting.signature:signature-pad:0.0.20"

    // Okio
    const val okio = "com.squareup.okio:okio:3.2.0"
    const val jakewharton = "com.jakewharton.threetenabp:threetenabp:1.4.6"

    private const val implementation = "implementation"
    private const val kapt = "kapt"
    private const val testImplementation = "testImplementation"
    private const val androidTestImplementation = "androidTestImplementation"
    private const val debugImplementation = "debugImplementation"

    fun Project.addDefaultsDependencies() {
        addAndroid()
        addCompose()
        addMaterial()
        addHilt()
        addLottie()
        addHilt()
        addTests()
        addCulqiSdk()
    }

    fun Project.addAndroid() {
        dependencies {
            add(implementation, coreKtx)
            add(implementation, lifecycleRuntime)
            add(implementation, appCompat)
        }
    }

    fun Project.addMaterial() {
        dependencies {
            add(implementation, uiMaterial3)
            add(implementation, material)
            add(implementation, uiMaterial)
            add(implementation, constraintLayout)
        }
    }

    private fun Project.addCompose() {
        dependencies {
            add(implementation, activityCompose)
            add(implementation, uiCompose)
            add(implementation, uiComposePreview)
            add(implementation, composeNavigation)
            add(implementation, COMPOSE_HILT_NAVIGATION)
            add(implementation, uiConstraint)
            add(implementation, accompanist)
        }
    }

    private fun Project.addLottie() {
        dependencies {
            add(implementation, lottie)
        }
    }

    fun Project.addHilt() {
        dependencies {
            add(implementation, HILT)
            add(kapt, HILT_ANDROID_COMPILER)
        }
    }

    fun Project.addCulqiSdk() {
        dependencies {
            add(implementation, project(path = ":culqisdk", configuration = "default"))
            add(implementation, okio)
            add(implementation, jakewharton)
        }
    }

    fun Project.addSignature() {
        dependencies {
            add(implementation, signature)
        }
    }

    fun Project.addCommonsModules() {
        addConstantsModule()
        addUiModule()
    }

    fun Project.addConstantsModule() {
        dependencies {
            add(implementation, project(Modules.constants))
        }
    }

    fun Project.addAnimationModule() {
        dependencies {
            add(implementation, project(Modules.animation))
        }
    }

    fun Project.addCancelModule() {
        dependencies {
            add(implementation, project(Modules.annulation))
        }
    }
    fun Project.addReadCardModule() {
        dependencies {
            add(implementation, project(Modules.readcard))
        }
    }

    private fun Project.addTests() {
        dependencies {
            add(testImplementation, junit)
            add(androidTestImplementation, junitExt)
            add(androidTestImplementation, coreEspresso)
            add(androidTestImplementation, uiTestCompose)
            add(debugImplementation, uiTooling)
            add(debugImplementation, uiManifest)
        }
    }

    private fun Project.addUiModule() {
        dependencies {
            add(implementation, project(Modules.ui))
        }
    }
}
