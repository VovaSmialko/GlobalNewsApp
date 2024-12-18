package com.smialko.globalnewsapp.domain.usecases.news

import com.smialko.globalnewsapp.data.local.NewsDao
import com.smialko.globalnewsapp.domain.model.Article
import com.smialko.globalnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(

    private val newsRepository: NewsRepository
) {


    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticle()
    }
}