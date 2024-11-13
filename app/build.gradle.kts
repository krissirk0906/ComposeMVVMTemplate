plugins {
    alias(lib.plugins.android.application)
    alias(lib.plugins.kotlin.android)
    alias(lib.plugins.devtools.ksp)
    alias(lib.plugins.hilt.gradle)
    id ("kotlin-kapt")
}

android {
    namespace = "com.junenine.composetemplate"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.junenine.composetemplate.dev"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

        kotlinOptions {
            jvmTarget = "17"
        }


    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = lib.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(lib.androidx.core.ktx)
    implementation(lib.compose.ui)
    implementation(lib.compose.ui.tooling.preview)
    implementation(lib.lifecycle.runtime.ktx)
    implementation(lib.activity.compose)
    testImplementation(lib.junit)
    androidTestImplementation(lib.test.ext.junit)
    androidTestImplementation(lib.espresso.core)
    androidTestImplementation(lib.ui.test.junit4)
    debugImplementation(lib.ui.tooling)
    implementation(lib.lifecycle.viewmodel.compose)
    implementation(lib.runtime.livedata)
    implementation (libs.dagger.hilt.android)
    kapt (libs.dagger.hilt.compiler)
    implementation(lib.hilt.navigation.compose)
    implementation(lib.retrofit)
    implementation(lib.okhttp)
    implementation(lib.converter.gson)
    implementation(lib.logging.interceptor)
    implementation(lib.navigation.compose)
    implementation(lib.lottie.compose)
    implementation(lib.coil.compose)
    implementation(lib.room.runtime)
    ksp(lib.room.compiler)
    implementation(lib.timber)
    implementation(lib.gson)
    implementation(lib.accompanist.pager)
    implementation(lib.accompanist.pager.indicators)
    implementation(lib.compose.material3)
    implementation(lib.androidx.startup.runtime)
    implementation (libs.utils)
    implementation (libs.crashcatcher)
}