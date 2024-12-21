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
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(modifier = modifier) {
        Text(text = "Login Screen")
        Button(
            onClick = {
                navController.navigate(HomeDestination.route) {
                    launchSingleTop = true
                    restoreState = true
                    popUpTo(LoginDestination.route) {
                        saveState = true
                        inclusive = true
                    }
                }
            }
        ) { Text(text = "Log in") }
    }
}
