package com.example.rustoreapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.rustoreapp.navigation.setupNavigation
import com.example.rustoreapp.ui.theme.RuStoreAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val isFirstLaunch = sharedPreferences.getBoolean("is_first_launch", true)

        setContent {
            RuStoreAppTheme {
                val navController = rememberNavController()
                val startDestination = if (isFirstLaunch) "onboarding" else "gallery"

                NavHost(
                    navController = navController,
                    startDestination = startDestination
                ) {
                    setupNavigation(navController)
                }

                if (isFirstLaunch) {
                    LaunchedEffect(Unit) {
                        sharedPreferences.edit().putBoolean("is_first_launch", false).apply()
                    }
                }
            }
        }
    }
}