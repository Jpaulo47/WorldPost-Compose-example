package com.joaorodrigues.theworldpost.domain.usecases.news

import com.joaorodrigues.theworldpost.domain.model.Article
import com.joaorodrigues.theworldpost.domain.repository.NewsRepository
import javax.inject.Inject

class SelectArticle  @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticle(url)
    }
}