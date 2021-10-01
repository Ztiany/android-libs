plugins {
    id("com.android.library")
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

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //测试
    testImplementation(TestLibraries.junit)

    //AndroidSupport
    api(AndroidLibraries.activityKtx)
    api(AndroidLibraries.fragmentKtx)
    api(AndroidLibraries.appcompat)
    compileOnly(AndroidLibraries.annotations)

    //Log
    api(ThirdLibraries.timber)

    //ImageLoader
    api(ThirdLibraries.glide)
    api(ThirdLibraries.glideOkHttp)
    api(ThirdLibraries.okHttp)
}