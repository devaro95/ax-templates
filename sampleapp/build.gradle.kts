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
        buildConfig = true
    }
    flavorDimensions.add("environment")
    productFlavors {
        create("sample") {
            dimension = "environment"
            buildConfigField("String", "API_KEY", "\"TdjqUle7OtodDZyVVj879CD6FeUXQOc0QejxyGot\"")
            buildConfigField(
                "String",
                "APPLICATION_ID",
                "\"CnWQkanA3YNT6LmSCbBkaPBQ2n6XhtwiOoGgN3Jj\""
            )
            buildConfigField("String", "BASE_URL", "\"https://parseapi.back4app.com/\"")
        }
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
    implementation(libs.http3)
    implementation(libs.retrofit.gson)
    debugImplementation(libs.ui.tooling)
}