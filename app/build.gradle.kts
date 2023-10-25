import com.cabrera.willard.configuration.constants.AndroidBuildConfig

plugins {
    id("plugins.config.app")
}

android {
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidBuildConfig.composeVersion
    }
}

dependencies {

    val composeBom = platform(libs.compose.boom)
    implementation(composeBom)
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(libs.bundles.app.implements)
    kapt(libs.bundles.kapt)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.bundles.app.androidTest)
    testImplementation(libs.bundles.test)
    debugImplementation(libs.bundles.app.debud.implements)
}
