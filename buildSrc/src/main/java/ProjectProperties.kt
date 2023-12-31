import org.gradle.api.JavaVersion

object ProjectProperties {
    object Test {
        const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Id {
        const val APPLICATION_ID = "com.msg.sms_android"
    }

    object Files {
        const val CONSUMER_PROGUARDFILES = "consumer-rules.pro"
        const val DEFAULT_PROGUARDFILES = "proguard-android-optimize.txt"
        const val PROGUARDFILES = "proguard-rules.pro"
    }

    object Versions {
        const val COMPILE_SDK = 33
        const val MIN_SDK = 24
        const val TARGET_SDK = 33
        const val JVM_TARGET = "17"
        const val VERSION_CODE = 11
        const val VERSION_NAME = "1.1.5"
        val JAVA_VERSION = JavaVersion.VERSION_17
    }

    object NameSpace {
        const val PRESENTATION = "com.forest.presentation"
        const val DOMAIN = "com.forest.domain"
        const val DATA = "com.forest.data"
        const val APP = "com.kin.forest_android"
    }
}