plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.fofito.ac.fofinotesapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.fofito.ac.fofinotesapp"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //room
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.annotation.compiler)
    kapt(libs.room.annotation.compiler)
    implementation(libs.room.ktx)
    testImplementation(libs.room.testing)

    //Compose lifecycle
    implementation(libs.androidx.lifecycle.runtime.compose)

    //Material3
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material3.size)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.gson)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //ktx
    implementation(libs.androidx.fragment.ktx)

    //Coil
    implementation(libs.coil.compose)

    //okhttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //Motion layout
    implementation(libs.androidx.constraintlayout.compose)

    //Navigation compose
    implementation(libs.androidx.navigation.compose)

    //Navigation compose Hilt
    implementation(libs.androidx.hilt.navigation.compose)

    //accompanist
    implementation(libs.accompanist.systemuicontroller)


}