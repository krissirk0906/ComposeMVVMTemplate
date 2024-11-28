plugins {
    alias(lib.plugins.android.application)
    alias(lib.plugins.kotlin.android)
    alias(lib.plugins.devtools.ksp)
    alias(lib.plugins.hilt.gradle)
    alias(lib.plugins.compose.compiler)
}

android {
    namespace = "com.junenine.composetemplate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.junenine.composetemplate.dev"
        minSdk = 24
        targetSdk = 34
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
    }

    composeCompiler {
        enableStrongSkippingMode = true
    }
}

dependencies {
    implementation(lib.androidx.core.ktx)
    implementation(lib.androidx.compose.bom)
    implementation(lib.compose.ui.tooling.preview)
    implementation(lib.lifecycle.runtime.ktx)
    implementation(lib.activity.compose)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.ui.tooling.preview.android)
    testImplementation(lib.junit)
    androidTestImplementation(lib.test.ext.junit)
    androidTestImplementation(lib.espresso.core)
    implementation (libs.dagger.hilt.android)
    ksp (libs.dagger.hilt.compiler)
    implementation(lib.retrofit)
    implementation(lib.okhttp)
    implementation(lib.converter.gson)
    implementation(lib.logging.interceptor)
    implementation(lib.lottie.compose)
    implementation(lib.coil.compose)
    implementation(lib.room.runtime)
    ksp(lib.room.compiler)
    implementation(lib.timber)
    implementation(lib.gson)
    implementation(lib.accompanist.pager)
    implementation(lib.accompanist.pager.indicators)
    implementation(lib.androidx.startup.runtime)
    implementation(libs.androidx.material3)
}