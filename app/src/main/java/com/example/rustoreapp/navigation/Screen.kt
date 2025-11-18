package com.example.rustoreapp.navigation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object AppGallery : Screen("app_gallery")
    object CategoryList : Screen("category_list")
    object AppDetails : Screen("app_details/{appId}") {
        fun createRoute(appId: Long) = "app_details/$appId"
    }
}