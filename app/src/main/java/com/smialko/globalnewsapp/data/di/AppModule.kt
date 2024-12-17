package com.smialko.globalnewsapp.data.di

import android.app.Application
import com.smialko.globalnewsapp.data.manager.LocalUserManagerImpl
import com.smialko.globalnewsapp.data.remote.dto.NewsApi
import com.smialko.globalnewsapp.data.repository.NewsRepositoryImpl
import com.smialko.globalnewsapp.domain.manager.LocalUserManager
import com.smialko.globalnewsapp.domain.repository.NewsRepository
import com.smialko.globalnewsapp.domain.usecases.app_entry.AppEntryUseCases
import com.smialko.globalnewsapp.domain.usecases.app_entry.ReadAppEntry
import com.smialko.globalnewsapp.domain.usecases.app_entry.SaveAppEntry
import com.smialko.globalnewsapp.domain.usecases.news.GetNews
import com.smialko.globalnewsapp.domain.usecases.news.NewsUseCases
import com.smialko.globalnewsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun providesAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}