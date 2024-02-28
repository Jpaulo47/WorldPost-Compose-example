package com.joaorodrigues.theworldpost.data.remote

import com.joaorodrigues.theworldpost.data.remote.dto.NewsResponse
import com.joaorodrigues.theworldpost.util.Constants.API_KEY
import retrofit2.http.Query

interface NewsApi {
    suspend fun getNews(
        @Query("pages") pages: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}