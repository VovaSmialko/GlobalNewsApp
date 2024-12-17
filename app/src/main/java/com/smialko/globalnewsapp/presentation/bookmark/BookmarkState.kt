package com.smialko.globalnewsapp.presentation.bookmark

import com.smialko.globalnewsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
