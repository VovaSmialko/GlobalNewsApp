package com.smialko.globalnewsapp.presentation.onboarding

sealed class OnBoardingEvent {


    data object SaveAppEntry: OnBoardingEvent()
}
