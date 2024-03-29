package com.joaorodrigues.theworldpost.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joaorodrigues.theworldpost.domain.model.Article
/**
Implements [PagingSource], a Jetpack class for loading paginated data.
Uses [NewsApi] to load news API data in a paginated form.
Keeps track of the total number of news stories uploaded.
Overrides the load() and getRefreshKey() methods.
 */
class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String
) : PagingSource<Int, Article>() {

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.getNews(pages = page, sources = sources)
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }//remove duplicates
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = if (page == 1) null else page - 1,
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}