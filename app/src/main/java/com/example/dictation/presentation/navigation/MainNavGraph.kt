package com.example.dictation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dictation.presentation.ui.SplashScreen

@Composable
fun MainNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = MainNavigation.Splash.navigationName(),
    ) {
        composable(MainNavigation.Splash.navigationName()) {
            SplashScreen {
                navController.navigate(DictationNavigation.routeName)
            }
        }
        composable(route = DictationNavigation.routeName) {
            DictationScreen(navController = navController,)
        }
    }
}
