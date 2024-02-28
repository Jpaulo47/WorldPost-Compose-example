package com.joaorodrigues.theworldpost.data.remote.dto

import com.joaorodrigues.theworldpost.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)