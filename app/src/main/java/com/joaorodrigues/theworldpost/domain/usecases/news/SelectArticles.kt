package com.joaorodrigues.theworldpost.domain.usecases.news

import com.joaorodrigues.theworldpost.data.local.NewsDao
import com.joaorodrigues.theworldpost.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}