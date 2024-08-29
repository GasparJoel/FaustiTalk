package com.faustino.faustitalk.Navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.Navigation.Graphs.MainNavGraph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel

@Composable
fun MainScreen(navHostController: NavHostController = rememberNavController(),authViewModel: AuthViewModel) {

    Scaffold (
        bottomBar = {BottonBar(navHostController)},
    ){ paddingValues ->
        var modifier = Modifier.padding(paddingValues)
        MainNavGraph(navHostController)
    }

}



@Composable
fun BottonBar(navController: NavController) {
    val screen = listOf(
        BottonBarScreen.Home,
        BottonBarScreen.Search,
        BottonBarScreen.Post,
        BottonBarScreen.Inbox,
        BottonBarScreen.Profile,
    )

    val navbackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navbackStackEntry?.destination

    val bottonBarDestination = screen.any{ it.route == currentDestination?.route}
    if (bottonBarDestination){

        NavigationBar {
            screen.forEach { pages ->
                AddItems(
                    pages,
                    currentDestination,
                    navController)
            }
        }
    }

}

@Composable
fun RowScope.AddItems(
    pages: BottonBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
) {
    NavigationBarItem(
        label = { Text(text = pages.route)},
        selected = currentDestination?.hierarchy?.any{it.route == pages.route} == true,
        onClick = { navController.navigate(pages.route){
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        } },
        icon = { Icon(imageVector = pages.icon, contentDescription = "icon_image") })

}