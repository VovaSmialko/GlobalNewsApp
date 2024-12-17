package com.smialko.globalnewsapp.presentation.details

sealed class DetailsEvent {

    data object SaveArticle : DetailsEvent()

}