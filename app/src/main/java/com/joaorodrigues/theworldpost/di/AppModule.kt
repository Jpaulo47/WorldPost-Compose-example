package com.joaorodrigues.theworldpost.di

import android.app.Application
import androidx.room.Room
import com.joaorodrigues.theworldpost.data.local.NewsDao
import com.joaorodrigues.theworldpost.data.local.NewsDatabase
import com.joaorodrigues.theworldpost.data.local.NewsTypeConvertor
import com.joaorodrigues.theworldpost.data.manger.LocalUserMangerImpl
import com.joaorodrigues.theworldpost.data.remote.NewsApi
import com.joaorodrigues.theworldpost.data.repository.NewsRepositoryImpl
import com.joaorodrigues.theworldpost.domain.manger.LocalUserManager
import com.joaorodrigues.theworldpost.domain.repository.NewsRepository
import com.joaorodrigues.theworldpost.domain.usecases.appentry.AppEntryUseCases
import com.joaorodrigues.theworldpost.domain.usecases.appentry.ReadAppEntry
import com.joaorodrigues.theworldpost.domain.usecases.appentry.SaveAppEntry
import com.joaorodrigues.theworldpost.domain.usecases.news.DeleteArticle
import com.joaorodrigues.theworldpost.domain.usecases.news.GetNews
import com.joaorodrigues.theworldpost.domain.usecases.news.NewsUseCases
import com.joaorodrigues.theworldpost.domain.usecases.news.SearchNews
import com.joaorodrigues.theworldpost.domain.usecases.news.SelectArticle
import com.joaorodrigues.theworldpost.domain.usecases.news.SelectArticles
import com.joaorodrigues.theworldpost.domain.usecases.news.UpsertArticle
import com.joaorodrigues.theworldpost.util.Constants
import com.joaorodrigues.theworldpost.util.Constants.BASE_URL
import com.joaorodrigues.theworldpost.util.Constants.NEWS_DATABASE_NAME
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
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}