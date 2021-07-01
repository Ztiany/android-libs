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

    testOptions {
        unitTests.isReturnDefaultValues = true
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    implementation(AndroidLibraries.appcompat)
    implementation(AndroidLibraries.material)
    implementation(AndroidLibraries.annotations)

    api(AndroidLibraries.archRuntime)
    api(AndroidLibraries.archCommon)
    api(AndroidLibraries.fragmentKtx)
    api(AndroidLibraries.lifecycleCommon)
    api(AndroidLibraries.lifecycleCommonJava8)

    implementation(ThirdLibraries.rxJava)
    implementation(ThirdLibraries.retrofit)
    implementation(ThirdLibraries.retrofitConverterGson)
    implementation(ThirdLibraries.okHttp)
    implementation(ThirdLibraries.gson)
    implementation(ThirdLibraries.retrofitRxJava2CallAdapter)
    implementation(ThirdLibraries.timber)

    api("com.tencent.mm.opensdk:wechat-sdk-android-without-mta:5.1.6")
}