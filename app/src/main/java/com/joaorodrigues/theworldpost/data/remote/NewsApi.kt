package com.joaorodrigues.theworldpost.data.remote

import com.joaorodrigues.theworldpost.data.remote.dto.NewsResponse
import com.joaorodrigues.theworldpost.util.Constants.API_KEY
import retrofit2.http.Query

/**
 * Interface that defines methods for interacting with the News API.
 * It has a getNews() method that takes parameters such as number of pages, news sources and an API key.
 * This method returns a [NewsResponse] object.
 */
interface NewsApi {
    suspend fun getNews(
        @Query("pages") pages: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}