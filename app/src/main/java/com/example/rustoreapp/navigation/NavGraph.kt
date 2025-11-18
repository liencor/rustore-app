package com.example.rustoreapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.rustoreapp.data.AppRepository
import com.example.rustoreapp.screens.appdetails.AppDetailsScreen
import com.example.rustoreapp.screens.appgallery.AppGalleryScreen
import com.example.rustoreapp.screens.categorylist.CategoryListScreen
import com.example.rustoreapp.screens.onboarding.OnboardingScreen
import com.example.rustoreapp.screens.fullscreenshots.FullscreenScreenshotsScreen

fun NavGraphBuilder.setupNavigation(navController: NavHostController) {
    composable("onboarding") {
        OnboardingScreen(navController)
    }

    composable("gallery") {
        AppGalleryScreen(navController)
    }

    composable("gallery/{category}") { backStackEntry ->
        val category = backStackEntry.arguments?.getString("category") ?: ""
        AppGalleryScreen(navController, category)
    }

    composable("categories") {
        CategoryListScreen(navController)
    }

    composable("app_details/{appId}") { backStackEntry ->
        val appId = backStackEntry.arguments?.getString("appId")?.toLongOrNull() ?: 0
        AppDetailsScreen(navController = navController, appId = appId)
    }

    composable("fullscreen_screenshots/{appId}/{initialPage}") { backStackEntry ->
        val appId = backStackEntry.arguments?.getString("appId")?.toLongOrNull() ?: 0
        val initialPage = backStackEntry.arguments?.getString("initialPage")?.toIntOrNull() ?: 0

        val repository = AppRepository()
        val app = repository.getAllApps().find { it.id == appId }

        if (app != null) {
            FullscreenScreenshotsScreen(
                navController = navController,
                screenshotResIds = app.screenshotResIds,
                initialPage = initialPage
            )
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Приложение не найдено")
            }
        }
    }
}