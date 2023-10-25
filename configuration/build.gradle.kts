plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

apply(plugin = "jacoco")

group = "com.cabrera.willard.configuration"
version = "SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jlleitschuh.gradle:ktlint-gradle:11.6.1")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.0.4")
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:8.1.2")
    implementation("com.android.tools.build:gradle-api:8.1.2")
    implementation(kotlin("gradle-plugin", "1.8.10"))
}

gradlePlugin {
    plugins {
        register("configuration") {
            id = "configuration"
            implementationClass = "com.cabrera.willard.configuration.plugins.ConfigurationPlugin"
        }
        register("FlavorsAppPlugin") {
            id = "plugins.config.app"
            implementationClass = "com.cabrera.willard.configuration.plugins.ConfigAppPlugin"
        }
        register("FlavorsLibraryPlugin") {
            id = "plugins.config.library"
            implementationClass = "com.cabrera.willard.configuration.plugins.ConfigLibraryPlugin"
        }
        register("ConfigEndpointsPlugin") {
            id = "plugins.config.endpoints"
            implementationClass = "com.cabrera.willard.configuration.plugins.ConfigEndpointsPlugin"
        }
        register("JacocoPlugin") {
            id = "plugins.jacoco"
            implementationClass = "com.cabrera.willard.configuration.plugins.JacocoPlugin"
        }
    }
}
