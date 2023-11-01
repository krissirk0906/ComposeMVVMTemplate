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
    alias(myLibs.plugins.android.application) apply false
    alias(myLibs.plugins.android.library) apply false
    alias(myLibs.plugins.kotlin.android) apply false
    alias(myLibs.plugins.devtools.ksp) apply false
}
