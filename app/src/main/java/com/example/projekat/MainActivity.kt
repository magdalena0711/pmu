package com.example.projekat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projekat.screens.ChallengesScreen
import com.example.projekat.screens.FriendsScreen
import com.example.projekat.screens.HomeScreen
import com.example.projekat.screens.LoginScreen
import com.example.projekat.screens.RegisterScreen
import com.example.projekat.screens.SetGoalScreen
import com.example.projekat.ui.theme.ProjekatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
             ProjekatTheme{
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination
    val currentRoute = currentDestination?.route ?: LoginDestination.route

    Scaffold(
        bottomBar = {
            if (currentRoute != LoginDestination.route && currentRoute != RegisterDestination.route) {
                NavigationBar {
                    homeNavigation.forEach { navDestination ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = navDestination.icon,
                                    contentDescription = null,
                                )
                            },
                            label = { Text(text = navDestination.route) },
                            selected = currentRoute.startsWith(navDestination.route),
                            onClick = {
                                navController.navigate(navDestination.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(HomeDestination.route) {
                                        saveState = true
                                        inclusive = false
                                    }
                                }
                            },
                        )
                    }
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = LoginDestination.route,
            modifier = Modifier.padding(it),
        ) {
            composable(route = LoginDestination.route) {
                LoginScreen(modifier = modifier, navController = navController)
            }
            composable(route = RegisterDestination.route) {
                RegisterScreen(modifier = modifier, navController = navController)
            }
            composable(route = HomeDestination.route) {
                HomeScreen(modifier = modifier, navController = navController)
            }
            composable(route = SetGoalDestination.route) {
                SetGoalScreen(modifier = modifier, navController = navController)
            }
            composable(route = FriendsDestination.route) {
                FriendsScreen(modifier = modifier, navController = navController)
            }
            composable(route = ChallengesDestination.route) {
                ChallengesScreen(modifier = modifier, navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjekatTheme {
        MainApp()
    }
}