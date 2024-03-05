package com.joaorodrigues.theworldpost.presentation.bookmark

import com.joaorodrigues.theworldpost.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)