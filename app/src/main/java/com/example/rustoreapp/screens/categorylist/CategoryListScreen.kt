package com.example.rustoreapp.screens.categorylist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rustoreapp.components.CategoryItem
import com.example.rustoreapp.data.AppRepository

@Composable
fun CategoryListScreen(navController: NavHostController) {
    val repository = AppRepository()
    val categories = repository.getAllApps()
        .groupBy { it.category }
        .mapValues { it.value.size }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, "Назад")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Категории",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            categories.forEach { (category, count) ->
                item {
                    CategoryItem(
                        category = category,
                        appCount = count,
                        onClick = {
                            navController.navigate("gallery/$category")
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}