package com.example.rustoreapp.data

data class App(
    val id: Long,
    val name: String,
    val developer: String,
    val iconResId: Int,
    val shortDescription: String,
    val fullDescription: String,
    val category: String,
    val ageRating: String,
    val screenshotResIds: List<Int>
)