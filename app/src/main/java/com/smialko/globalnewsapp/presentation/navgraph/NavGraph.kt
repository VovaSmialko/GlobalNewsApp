package com.smialko.globalnewsapp.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.smialko.globalnewsapp.presentation.bookmark.BookmarkScreen
import com.smialko.globalnewsapp.presentation.bookmark.BookmarkViewModel
import com.smialko.globalnewsapp.presentation.home.HomeScreen
import com.smialko.globalnewsapp.presentation.home.HomeViewModel
import com.smialko.globalnewsapp.presentation.news_navigator.NewsNavigator
import com.smialko.globalnewsapp.presentation.onboarding.OnBoardingScreen
import com.smialko.globalnewsapp.presentation.onboarding.OnBoardingViewModel
import com.smialko.globalnewsapp.presentation.search.SearchScreen
import com.smialko.globalnewsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStarNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        ) {
            composable(route = Route.NewsNavigationScreen.route) {
                NewsNavigator()
            }
        }
    }
}