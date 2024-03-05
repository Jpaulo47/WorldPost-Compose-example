package com.joaorodrigues.theworldpost.domain.repository

import androidx.paging.PagingData
import com.joaorodrigues.theworldpost.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>

}