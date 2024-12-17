package com.smialko.globalnewsapp.presentation.search

import androidx.paging.PagingData
import com.smialko.globalnewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
) {
}