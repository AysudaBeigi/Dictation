package com.example.dictation.presentation.navigation

sealed class DictationNavigation(val route: String) {
    fun navigationName() = "dictation/$route"

    object Words : DictationNavigation("words")
    object SelectLevel : DictationNavigation("select-level")
    object Profile : DictationNavigation("profile")

}