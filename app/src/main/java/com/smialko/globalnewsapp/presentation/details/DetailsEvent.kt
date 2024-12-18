package com.smialko.globalnewsapp.presentation.details

import com.smialko.globalnewsapp.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    data object RemovingSideEffect : DetailsEvent()

}