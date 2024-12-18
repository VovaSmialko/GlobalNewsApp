package com.smialko.globalnewsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.smialko.globalnewsapp.data.local.NewsDao
import com.smialko.globalnewsapp.data.remote.dto.NewsApi
import com.smialko.globalnewsapp.data.remote.dto.NewsPagingSource
import com.smialko.globalnewsapp.data.remote.dto.SearchNewsPagingSource
import com.smialko.globalnewsapp.domain.model.Article
import com.smialko.globalnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi,

    private val newsDao: NewsDao
) : NewsRepository {
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = source.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    api = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    override fun selectArticle(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

    override suspend fun selectArticles(url: String): Article? {
        return newsDao.getArticle(url)
    }
}
