package com.smialko.globalnewsapp.domain.usecases.news

import com.smialko.globalnewsapp.data.local.NewsDao
import com.smialko.globalnewsapp.domain.model.Article
import com.smialko.globalnewsapp.domain.repository.NewsRepository

class DeleteArticle(

    private val newsRepository: NewsRepository
) {


    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}