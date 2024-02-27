package com.joaorodrigues.theworldpost.presentation.nvgraph

sealed class Route(
    val route: String
) {

    object OnBoardingScreen: Route(route = "onBoardingScreen")
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object BookmarksScreen: Route(route = "bookmarksScreen")
    object DetailScreen: Route(route = "detailScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
    object NewsNavigation: Route(route = "newsNavigation")
    object NewsNavigationScreen: Route(route = "newsNavigationScreen")

}