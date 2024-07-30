import com.android.build.api.variant.BuildConfigField
import org.gradle.internal.impldep.com.jcraft.jsch.ConfigRepository.defaultConfig

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}

buildscript {
    dependencies {
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}





