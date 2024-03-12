package com.joaorodrigues.theworldpost.domain.usecases.news

import com.joaorodrigues.theworldpost.data.local.NewsDao
import com.joaorodrigues.theworldpost.domain.model.Article
import com.joaorodrigues.theworldpost.domain.repository.NewsRepository
import javax.inject.Inject

class UpsertArticle  @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }
}