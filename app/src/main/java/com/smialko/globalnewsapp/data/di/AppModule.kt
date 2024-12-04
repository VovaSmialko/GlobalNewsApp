package com.smialko.globalnewsapp.data.di

import android.app.Application
import com.smialko.globalnewsapp.data.manager.LocalUserManagerImpl
import com.smialko.globalnewsapp.domain.manager.LocalUserManager
import com.smialko.globalnewsapp.domain.usecases.AppEntryUseCases
import com.smialko.globalnewsapp.domain.usecases.ReadAppEntry
import com.smialko.globalnewsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}