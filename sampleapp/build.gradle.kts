plugins {
    `maven-publish`
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}


android {
    namespace = "com.sampleapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sampleapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core"))

    implementation(libs.material)
    implementation(libs.compose.runtime)
    implementation(libs.material3)
    implementation(libs.compose.activity)
    implementation(libs.koin.compose)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)
}