package com.smialko.globalnewsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.smialko.globalnewsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


val pages = listOf(
    Page(
        title = "BullRun, Bullish or not?",
        description = "Today we gonna to brake new ATH",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Good mood and good vibes for all",
        description = "You will learn new information about monkeys",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Pizza, Deserts, Ukrainian borsh",
        description = "how to cook best breakfast in the world",
        image = R.drawable.onboarding3
    ),
)
