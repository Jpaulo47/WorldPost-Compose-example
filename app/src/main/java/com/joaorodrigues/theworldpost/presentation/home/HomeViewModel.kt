package com.joaorodrigues.theworldpost.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.joaorodrigues.theworldpost.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    newsUseCases: NewsUseCases
) : ViewModel() {

    val news = newsUseCases.getNews(
        sources = listOf("bbc-news", "cnn", "the-washington-post", "the-new-york-times", "fox-news")
    ).cachedIn(viewModelScope)

}