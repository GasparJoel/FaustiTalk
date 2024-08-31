package com.faustino.faustitalk.Navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding



import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.Navigation.Graphs.MainNavGraph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.ui.theme.Dark900
import com.faustino.faustitalk.ui.theme.Green300

@Composable
fun MainScreen(navHostController: NavHostController = rememberNavController(),authViewModel: AuthViewModel) {

    Scaffold (
        bottomBar = { BottomBarCustom(navController = navHostController)},
    ){ paddingValues ->
        var modifier = Modifier.padding(paddingValues)
        MainNavGraph(navHostController,authViewModel)
    }

}

@Composable
fun BottomBarCustom(navController: NavController) {
    val  selected = remember {
        mutableStateOf( BottonBarScreen.Home.icon )
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
            selected.value = screen.icon
            navController.navigate( screen.route ){
                popUpTo(0)
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