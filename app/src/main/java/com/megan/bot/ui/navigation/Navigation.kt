package com.megan.bot.ui.navigation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.megan.bot.ui.screens.*

sealed class Screen(val route: String, val title: String, val icon: ImageVector, val selectedIcon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Outlined.Home, Icons.Filled.Home)
    object AIChat : Screen("ai_chat", "AI Chat", Icons.Outlined.Chat, Icons.Filled.Chat)
    object Downloads : Screen("downloads", "Downloads", Icons.Outlined.Download, Icons.Filled.Download)
    object News : Screen("news", "News", Icons.Outlined.Newspaper, Icons.Filled.Newspaper)
    object Tools : Screen("tools", "Tools", Icons.Outlined.Build, Icons.Filled.Build)
    object More : Screen("more", "More", Icons.Outlined.MoreHoriz, Icons.Filled.MoreHoriz)
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.AIChat,
    Screen.Downloads,
    Screen.News,
    Screen.More
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NorbotNavHost() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomNavItems.map { it.route }) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp
                ) {
                    bottomNavItems.forEach { screen ->
                        val selected = currentRoute == screen.route
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    if (selected) screen.selectedIcon else screen.icon,
                                    contentDescription = screen.title
                                )
                            },
                            label = { Text(screen.title) },
                            selected = selected,
                            onClick = {
                                if (currentRoute != screen.route) {
                                    navController.navigate(screen.route) {
                                        popUpTo(Screen.Home.route) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.AIChat.route) { AIChatScreen(navController) }
            composable(Screen.Downloads.route) { DownloadScreen(navController) }
            composable(Screen.News.route) { NewsScreen(navController) }
            composable(Screen.Tools.route) { ToolsScreen(navController) }
            composable(Screen.More.route) { MoreScreen(navController) }
            
            // Detail screens
            composable("ai_model/{model}") { backStackEntry ->
                val model = backStackEntry.arguments?.getString("model") ?: "gpt"
                AIModelScreen(navController, model)
            }
            composable("youtube_downloader") { YouTubeDownloadScreen(navController) }
            composable("tiktok_downloader") { TikTokDownloadScreen(navController) }
            composable("instagram_downloader") { InstagramDownloadScreen(navController) }
            composable("facebook_downloader") { FacebookDownloadScreen(navController) }
            composable("crypto") { CryptoScreen(navController) }
            composable("forex") { ForexScreen(navController) }
            composable("weather") { WeatherScreen(navController) }
            composable("games") { GamesScreen(navController) }
            composable("security") { SecurityScreen(navController) }
            composable("about") { AboutScreen(navController) }
            composable("contact") { ContactScreen(navController) }
        }
    }
}
