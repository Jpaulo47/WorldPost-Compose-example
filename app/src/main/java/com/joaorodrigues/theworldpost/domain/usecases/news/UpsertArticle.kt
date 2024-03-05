package com.joaorodrigues.theworldpost.domain.usecases.news

import com.joaorodrigues.theworldpost.data.local.NewsDao
import com.joaorodrigues.theworldpost.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}