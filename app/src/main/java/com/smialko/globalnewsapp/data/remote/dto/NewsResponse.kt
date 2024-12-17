package com.smialko.globalnewsapp.data.remote.dto

import com.smialko.globalnewsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)