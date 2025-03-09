package com.longkd.yourdailypluse.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.longkd.yourdailypluse.android.screens.AboutScreen
import com.longkd.yourdailypluse.android.screens.ArticlesScreen
import com.longkd.yourdailypluse.android.screens.Screens
import com.longkd.yourdailypluse.articles.ArticlesViewModel

/**
 * @Author: longkd
 * @Since: 17:17 - 8/3/25
 */
@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onAboutButtonClick = {
                    navController.navigate(Screens.ABOUT_DEVICE.route)
                }
            )
        }

        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen {
                navController.popBackStack()
            }
        }
    }
}