package com.example.projekat

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val icon: ImageVector
    val route: String
}

object LoginDestination : Destination {
    override val icon = Icons.Default.Lock
    override val route = "Login"
}

object RegisterDestination : Destination {
    override val icon = Icons.Default.AddCircle
    override val route = "Register"
}

object HomeDestination : Destination {
    override val icon = Icons.Default.Home
    override val route = "Home"
}

object SetGoalDestination : Destination {
    override val icon = Icons.Default.Edit
    override val route = "Set Goal"
}

object FriendsDestination : Destination {
    override val icon = Icons.Default.Person
    override val route = "Friends"
}

object ChallengesDestination : Destination {
    override val icon = Icons.Default.CheckCircle
    override val route = "Challenges"
}

val homeNavigation = listOf(SetGoalDestination, FriendsDestination, ChallengesDestination)

//val snippetDestinations = listOf(LoginDestination, DestinationB, DestinationC)