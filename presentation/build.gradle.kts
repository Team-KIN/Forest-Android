plugins {
    id (Dependency.Gradle.LIBRARY)
    id (Dependency.Gradle.KOTLIN)
    kotlin (Dependency.Gradle.KAPT)
    id (Dependency.Google.HILT_PLUGIN)
}

android {
    namespace = "com.kin.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 33
        targetSdk = 33

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
        sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
        targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.Versions.JVM_TARGET
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    buildFeatures {
        compose = true
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))

    //aac
    implementation(Dependency.AndroidX.APPCOMPAT)
    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE)
    implementation(Dependency.Navigation.NAVIGATION)

    //compose
    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_TOOLING)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    implementation(Dependency.Compose.COMPOSE_MATERIAL3)
    implementation(Dependency.Compose.COMPOSE_PREVIEW)

    //junit
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.COMPOSE_JUNIT)
    debugImplementation(Dependency.Compose.COMPOSE_TOOLING)
    debugImplementation(Dependency.Test.COMPOSE_MANIFEST)

    //retrofit
    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.RETROFIT_CONVERTER_GSON)

    //okhttp
    implementation(Dependency.Libraries.OKHTTP)
    implementation(Dependency.Libraries.OKHTTP_LOGGING_INTERCEPTOR)

    //hilt
    implementation(Dependency.Google.HILT)
    kapt(Dependency.Google.HILT_COMPILER)

    //androidTest
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO)

    //accompanist
    implementation(Dependency.Google.ACCOMPANIST)
    implementation(Dependency.Google.ACCOMPANIST_PERMISSION)

    //preference
    implementation(Dependency.DataStore.PREFERENCES)
}