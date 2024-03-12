package com.joaorodrigues.theworldpost.presentation.search

import androidx.paging.PagingData
import com.joaorodrigues.theworldpost.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null,
)