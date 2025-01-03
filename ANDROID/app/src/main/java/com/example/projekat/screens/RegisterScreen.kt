package com.example.projekat.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavHostController
import com.example.projekat.HomeDestination
import com.example.projekat.LoginDestination

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var repeatedPassword by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {
        Text(text = "Login Screen")
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            modifier = modifier
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = modifier
        )
        OutlinedTextField(
            value = repeatedPassword,
            onValueChange = { repeatedPassword = it },
            label = { Text(text = "Repeat password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = modifier
        )
        Button(
            onClick = {
                username = ""
                password = ""
                repeatedPassword = ""
                navController.navigate(LoginDestination.route) {
                    launchSingleTop = true
                    restoreState = true
                    popUpTo(LoginDestination.route) {
                        saveState = true
                        inclusive = false
                    }
                }
            },
            modifier = modifier
        )
        {
            Text(text = "Sign up")
        }
    }
}
