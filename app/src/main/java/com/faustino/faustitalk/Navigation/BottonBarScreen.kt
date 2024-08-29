package com.faustino.faustitalk.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottonBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,

) {
    object Home : BottonBarScreen(
        route = "HOME",
        title = "Home",
        icon = Icons.Default.Home,
    )
    object Inbox : BottonBarScreen(
        route = "INBOX",
        title = "Inbox",
        icon = Icons.Default.MailOutline,
    )
    object Post : BottonBarScreen(
        route = "POST",
        title = "Post",
        icon = Icons.Default.Star,
    )
    object Profile : BottonBarScreen(
        route = "PROFILE",
        title = "Profile",
        icon = Icons.Default.Person,
    )
    object Search : BottonBarScreen(
        route = "SEARCH",
        title = "Search",
        icon = Icons.Default.Search,
    )


}