package com.joaorodrigues.theworldpost.di

import android.app.Application
import com.joaorodrigues.theworldpost.data.manger.LocalUserMangerImpl
import com.joaorodrigues.theworldpost.domain.manger.LocalUserManager
import com.joaorodrigues.theworldpost.domain.usecases.AppEntryUseCases
import com.joaorodrigues.theworldpost.domain.usecases.ReadAppEntry
import com.joaorodrigues.theworldpost.domain.usecases.SaveAppEntry
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
    ): LocalUserManager = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun providerAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}