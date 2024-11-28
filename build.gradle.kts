buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    alias(lib.plugins.android.application) apply false
    alias(lib.plugins.android.library) apply false
    alias(lib.plugins.kotlin.android) apply false
    alias(lib.plugins.devtools.ksp) apply false
    alias(lib.plugins.hilt.gradle) apply false
    alias(libs.plugins.compose.compiler) apply false
}
