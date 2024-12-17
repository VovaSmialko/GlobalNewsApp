package com.smialko.globalnewsapp.domain.usecases.news

import com.smialko.globalnewsapp.data.local.NewsDao
import com.smialko.globalnewsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {


    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}