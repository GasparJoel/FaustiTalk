package com.faustino.faustitalk.Navigation.Graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.faustino.faustitalk.Navigation.BottonBarScreen
import com.faustino.faustitalk.View.Menu.HomeScreen
import com.faustino.faustitalk.View.Menu.InboxScreen
import com.faustino.faustitalk.View.Menu.PostScreen
import com.faustino.faustitalk.View.Menu.ProfileScreen
import com.faustino.faustitalk.View.Menu.SearchScreen

@Composable
fun MainNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottonBarScreen.Home.route,
        route = Graph.MAIN_SCREEN
    ){
        composable(route = BottonBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottonBarScreen.Inbox.route){
            InboxScreen()
        }
        composable(route = BottonBarScreen.Post.route){
            PostScreen()
        }
        composable(route = BottonBarScreen.Profile.route){
            ProfileScreen()
        }
        composable(route = BottonBarScreen.Search.route){
            SearchScreen()
        }

    }
}

