package com.smialko.globalnewsapp.domain.repository

import androidx.paging.PagingData
import com.smialko.globalnewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(source: List<String>): Flow<PagingData<Article>>
}