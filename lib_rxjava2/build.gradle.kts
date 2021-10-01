plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    lintOptions {
        isAbortOnError = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    testImplementation(TestLibraries.junit)

    api(project(":lib_foundation"))

    implementation(AndroidLibraries.annotations)
    implementation(ThirdLibraries.timber)

    api(AndroidLibraries.fragmentKtx)
    api(AndroidLibraries.lifecycleLiveDataCore)
    api(AndroidLibraries.lifecycleViewModelKtx)

    api(ThirdLibraries.supportOptional)

    api(ThirdLibraries.rxJava)
    api(ThirdLibraries.rxAndroid)
    api(ThirdLibraries.rxBinding)
    api(ThirdLibraries.autoDispose)
    api(ThirdLibraries.autoDisposeAndroid)
    api(ThirdLibraries.autoDisposeLifecycle)
    api(ThirdLibraries.autoDisposeLifecycleArchcomponents)
    
    api(KotlinLibraries.kotlinStdlib)
}
