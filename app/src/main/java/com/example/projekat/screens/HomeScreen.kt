package com.example.projekat.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.projekat.HomeDestination
import com.example.projekat.LoginDestination

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(modifier = modifier) {
        Text(text = "Home Screen")
        Button(
            onClick = {
                navController.navigate(LoginDestination.route) {
                    launchSingleTop = true
                    restoreState = true
                    popUpTo(HomeDestination.route) {
                        saveState = true
                        inclusive = true
                    }
                }
            }
        ) { Text(text = "Log out") }
    }
}