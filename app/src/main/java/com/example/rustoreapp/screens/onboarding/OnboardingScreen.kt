package com.example.rustoreapp.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rustoreapp.R

@Composable
fun OnboardingScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_rustore_logo),
            contentDescription = "RuStore Logo",
            modifier = Modifier.size(180.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Добро пожаловать в RuStore",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Официальный российский магазин приложений",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = {
                navController.navigate("gallery") {
                    popUpTo("onboarding") { inclusive = true }
                }
            }
        ) {
            Text("Начать просмотр")
        }
    }
}