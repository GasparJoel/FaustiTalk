package com.faustino.faustitalk.Navigation

import MetodosViewModel
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding



import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.Navigation.Graphs.MainNavGraph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.ui.theme.Dark900
import com.faustino.faustitalk.ui.theme.Green300

@Composable
fun MainScreen(
    homeNavHostController: NavHostController = rememberNavController(),
    rootNavHostController: NavHostController,
    authViewModel: AuthViewModel,
    metodosViewModel:MetodosViewModel
) {

    Scaffold (
        bottomBar = { BottomBarCustom(navController = homeNavHostController)},
    ){ paddingValues ->
        var modifier = Modifier.padding(paddingValues)
        MainNavGraph(

            rootNavHostController = rootNavHostController,
            homeNavHostController = homeNavHostController,
            authViewModel = authViewModel,
            modifier = modifier ,
            metodosViewModel=metodosViewModel
        )
    }

}

@Composable
fun BottomBarCustom(navController: NavHostController) {
    val  selected = remember {
        mutableStateOf( BottonBarScreen.Home.icon )
    }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            val currentRoute = backStackEntry.destination.route
            selected.value = when (currentRoute) {
                BottonBarScreen.Home.route -> BottonBarScreen.Home.icon
                BottonBarScreen.Search.route -> BottonBarScreen.Search.icon
                BottonBarScreen.Post.route -> BottonBarScreen.Post.icon
                BottonBarScreen.Inbox.route -> BottonBarScreen.Inbox.icon
                BottonBarScreen.Profile.route -> BottonBarScreen.Profile.icon
                else -> BottonBarScreen.Home.icon
            }
        }
    }
    BottomAppBar (
        containerColor = Dark900,
        actions = {
            IconBottomCustom(selected,BottonBarScreen.Home,navController)
            IconBottomCustom(selected,BottonBarScreen.Search,navController)
            IconBottomCustom(selected,BottonBarScreen.Post,navController)
            IconBottomCustom(selected,BottonBarScreen.Inbox,navController)
            IconBottomCustom(selected,BottonBarScreen.Profile,navController)
        }
    )
}

@Composable
fun RowScope.IconBottomCustom(
    selected: MutableState<ImageVector>,
    screen: BottonBarScreen,
    navController: NavController
) {
    IconButton(

        onClick = {
           // selected.value = screen.icon
            navController.navigate( screen.route ){
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) {
                        saveState = false
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        modifier = Modifier.weight(1f),
    ) {
        Icon(
            imageVector = screen.icon,
            contentDescription = "IconBar",
            modifier = Modifier.size(30.dp),
            tint = if (selected.value == screen.icon)  Green300 else Color.White
        )
    }
}


/*
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

}*/