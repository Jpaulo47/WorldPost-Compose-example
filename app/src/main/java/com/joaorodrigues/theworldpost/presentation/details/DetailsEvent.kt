package com.joaorodrigues.theworldpost.presentation.details

import com.joaorodrigues.theworldpost.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}