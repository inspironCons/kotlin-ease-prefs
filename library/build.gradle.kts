plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.rekanesia.kotlineaseprefs"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            consumerProguardFiles("consumer-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    java{
        toolchain{
            languageVersion = JavaLanguageVersion.of(17)
        }
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.security:security-crypto:1.1.0-alpha06")
}


configure<PublishingExtension> {
    publications.create<MavenPublication>("library") {
        groupId = "com.rekanesia"
        artifactId = "kotlin-ease-prefs"
        version = "1.0.0"
        pom{
            description = "Introducing KotlinEasePrefs: Your hassle-free solution for configuring preferences in Kotlin projects!"
        }

    }
    repositories {
        mavenLocal()
    }
}