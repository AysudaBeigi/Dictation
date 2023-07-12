package com.example.dictation.domain.usecase

import com.example.dictation.domain.Level
import com.example.dictation.domain.Repository
import com.example.dictation.domain.Word

class InsertWordsUseCase(private val repository: Repository) {
    suspend fun execute() {
        repository.insertWords(
            listOf(
                Word("Welcome", Level.EASY),
                Word("Android", Level.EASY),
                Word("developer", Level.EASY),
                Word("document", Level.EASY),
                Word("teach", Level.EASY),
                Word("build", Level.EASY),
                Word("app", Level.EASY),
                Word("framework", Level.EASY),
                Word("libraries", Level.EASY),
                Word("brand", Level.EASY),
                Word("want", Level.EASY),
                Word("jump", Level.EASY),
                Word("code", Level.EASY),
                Word("start", Level.EASY),
                Word("tutorial", Level.EASY),
                Word("check", Level.EASY),
                Word("user experience", Level.MIDDLE),
                Word("Visual Studio", Level.MIDDLE),
                Word("boilerplate", Level.MIDDLE),
                Word("make your code easier", Level.MIDDLE),
                Word("Modularization", Level.MIDDLE),
                Word("Work manager", Level.MIDDLE),
                Word("game engine", Level.MIDDLE),
                Word("Android GPU Inspector", Level.MIDDLE),
                Word("dependency integration", Level.MIDDLE),
                Word("project management", Level.MIDDLE),
                Word("memory profiler", Level.MIDDLE),
                Word("application bundle", Level.MIDDLE),
                Word("common requirements", Level.MIDDLE),
                Word("programming language", Level.MIDDLE),
                Word("Welcome to the Android developer guides", Level.HARD),
                Word("To get started, do a quick codelab or dive deeper into a training course for an overview of key Android development topics", Level.HARD),
                Word("As you create a series of apps, you’ll learn the basics of the Kotlin programming language and the fundamentals of app development.", Level.HARD),
                Word("Go deeper by exploring other training resources, such as learning pathways for more-advanced topics, including Compose, app architecture, and accessibility.", Level.HARD),
                Word("Find resources that educators can use to teach Android development.", Level.HARD),
                Word("If you learn best by reading code, there’s a wide range of sample Compose apps that you can check out, modify, and learn from.", Level.HARD),
                Word("Android apps can be written using Kotlin, the Java programming language, and C++ languages.", Level.HARD),
                Word("The Android SDK tools compile your code along with any data and resource files into an APK or an Android App Bundle.", Level.HARD),
                Word("An Android package, which is an archive file with an .apk suffix, contains the contents of an Android app required at runtime, and it is the file that Android-powered devices use to install the app.", Level.HARD),
                Word("An Android App Bundle, which is an archive file with an .aab suffix, contains the contents of an Android app project, including some additional metadata that isn't required at runtime.", Level.HARD),
                Word("When distributing your app through Google Play, for example, Google Play's servers generate optimized APKs that contain only the resources and code that are required by the particular device requesting installation of the app.", Level.HARD),
                Word("The Android operating system is a multi-user Linux system in which each app is a different user.", Level.HARD),
                Word("The Android system implements the principle of least privilege", Level.HARD),
                Word("The manifest file in which you declare the components and the required device features for your app.", Level.HARD),
                Word("A service is a general-purpose entry point for keeping an app running in the background for all kinds of reasons.", Level.HARD),
            )
        )
    }
}