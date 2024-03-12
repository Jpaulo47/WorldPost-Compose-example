package com.joaorodrigues.theworldpost.domain.usecases.news

import com.joaorodrigues.theworldpost.domain.model.Article
import com.joaorodrigues.theworldpost.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SelectArticles  @Inject constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticle()
    }
}