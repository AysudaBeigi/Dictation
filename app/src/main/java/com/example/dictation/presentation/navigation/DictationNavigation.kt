package com.example.dictation.presentation.navigation

sealed class DictationNavigation(private val navigationName: String) {
    companion object {
        const val routeName = "dictation"
    }
    fun navigationName() = "dictation/$navigationName"
    object Words : DictationNavigation("words")
    object SelectLevel : DictationNavigation("select-level")
    object Profile : DictationNavigation("profile")
    object Score : DictationNavigation("score")
}

sealed class MainNavigation(private val navigationName: String) {
    fun navigationName() = "main/$navigationName"

    object Splash : MainNavigation("splash")
}