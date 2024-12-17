package com.smialko.globalnewsapp.domain.usecases.news

import androidx.paging.PagingData
import com.smialko.globalnewsapp.domain.model.Article
import com.smialko.globalnewsapp.domain.model.Source
import com.smialko.globalnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(source: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(source = source)
    }
}