import com.cabrera.willard.configuration.constants.AndroidBuildConfig

plugins {
    id("plugins.config.library")
}

android {
    namespace = "${AndroidBuildConfig.basePackage}.domain"

    defaultConfig {
        testInstrumentationRunner = "com.cabrera.willard.domain.HiltTestRunner"
    }
}

dependencies {
    implementation(libs.bundles.library.implements)
    kapt(libs.bundles.kapt)
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.library.androidTest)
}
