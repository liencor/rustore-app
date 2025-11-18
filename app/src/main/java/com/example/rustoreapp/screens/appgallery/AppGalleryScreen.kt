package com.example.rustoreapp.screens.appgallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rustoreapp.components.AppItem
import com.example.rustoreapp.data.AppRepository

@Composable
fun AppGalleryScreen(
    navController: NavHostController,
    category: String? = null
) {
    val repository = AppRepository()
    val apps = if (category.isNullOrEmpty()) {
        repository.getAllApps()
    } else {
        repository.getAllApps().filter { it.category == category }
    }

    val screenTitle = if (category.isNullOrEmpty()) {
        "Витрина приложений"
    } else {
        "Категория: $category"
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!category.isNullOrEmpty()) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, "Назад")
                }
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(
                text = screenTitle,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )

            Button(onClick = {
                navController.navigate("categories")
            }) {
                Text("Категории")
            }
        }

        if (apps.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text("Нет приложений в этой категории")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(apps) { app ->
                    AppItem(app = app, navController = navController)
                }
            }
        }
    }
}