package com.joaorodrigues.theworldpost.di

import android.app.Application
import com.joaorodrigues.theworldpost.data.manger.LocalUserMangerImpl
import com.joaorodrigues.theworldpost.data.remote.NewsApi
import com.joaorodrigues.theworldpost.data.repository.NewsRepositoryImpl
import com.joaorodrigues.theworldpost.domain.manger.LocalUserManager
import com.joaorodrigues.theworldpost.domain.repository.NewsRepository
import com.joaorodrigues.theworldpost.domain.usecases.appentry.AppEntryUseCases
import com.joaorodrigues.theworldpost.domain.usecases.appentry.ReadAppEntry
import com.joaorodrigues.theworldpost.domain.usecases.appentry.SaveAppEntry
import com.joaorodrigues.theworldpost.domain.usecases.news.GetNews
import com.joaorodrigues.theworldpost.domain.usecases.news.NewsUseCases
import com.joaorodrigues.theworldpost.util.Constants.BASE_URL
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
    ): LocalUserManager = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun providerAppEntryUseCases(
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