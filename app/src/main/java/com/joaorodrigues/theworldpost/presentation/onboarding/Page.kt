package com.joaorodrigues.theworldpost.presentation.onboarding

import androidx.annotation.DrawableRes
import com.joaorodrigues.theworldpost.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Welcome to The World Post",
        description = "The World Post is a news app that brings you the latest news from around the world.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Stay Informed",
        description = "Get the latest news from around the world, all in one place.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Personalize Your News",
        description = "Customize your news feed to get the news that matters to you.",
        image = R.drawable.onboarding3
    ),
)
