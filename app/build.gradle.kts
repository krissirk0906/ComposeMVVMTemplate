plugins {
    alias(myLibs.plugins.android.application)
    alias(myLibs.plugins.kotlin.android)
    alias(myLibs.plugins.devtools.ksp)
}

android {
    namespace = "com.junenine.mvvmcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.junenine.mvvmcompose.dev"
        minSdk = 28
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

    composeOptions {
        kotlinCompilerExtensionVersion = myLibs.versions.compose.compiler.get()
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(myLibs.androidx.core.ktx)
    implementation(myLibs.compose.ui)
    implementation(myLibs.compose.ui.tooling.preview)
    implementation(myLibs.lifecycle.runtime.ktx)
    implementation(myLibs.activity.compose)
    testImplementation(myLibs.junit)
    androidTestImplementation(myLibs.test.ext.junit)
    androidTestImplementation(myLibs.espresso.core)
    androidTestImplementation(myLibs.ui.test.junit4)
    debugImplementation(myLibs.ui.tooling)
    implementation(myLibs.lifecycle.viewmodel.compose)
    implementation(myLibs.runtime.livedata)
    implementation(myLibs.dagger.hilt.android)
    ksp(myLibs.dagger.hilt.compiler)
    ksp(myLibs.hilt.compiler)
    implementation(myLibs.hilt.navigation.compose)
    implementation(myLibs.retrofit)
    implementation(myLibs.okhttp)
    implementation(myLibs.converter.gson)
    implementation(myLibs.logging.interceptor)
    implementation(myLibs.navigation.compose)
    implementation(myLibs.lottie.compose)
    implementation(myLibs.coil.compose)
    implementation(myLibs.room.runtime)
    ksp(myLibs.room.compiler)
    implementation(myLibs.timber)
    implementation(myLibs.gson)
    implementation(myLibs.accompanist.pager)
    implementation(myLibs.accompanist.pager.indicators)
    implementation(myLibs.compose.material3)
}
