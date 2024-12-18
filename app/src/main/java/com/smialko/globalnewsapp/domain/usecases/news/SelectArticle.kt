package com.smialko.globalnewsapp.domain.usecases.news

import com.smialko.globalnewsapp.data.local.NewsDao
import com.smialko.globalnewsapp.domain.model.Article
import com.smialko.globalnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticle(

    private val newsRepository: NewsRepository
) {


    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticles(url)
    }
}