package com.example.picklerick.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.picklerick.ui.navigation.RickAndMortyNavHost
import com.example.picklerick.ui.navigation.Screen
import com.example.picklerick.viewmodel.CharacterViewModel


@Composable
fun MainScreen(viewModel: CharacterViewModel, modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
       RickAndMortyNavHost(viewModel = viewModel, modifier = Modifier.padding(innerPadding), navController = navController)
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavigationItem(
            selected = currentRoute == Screen.Characters.route,
            onClick = { navController.navigate(Screen.Characters.route) },
            icon = { Icon(Icons.Default.Person, contentDescription = "Characters") },
            label = { Text("Chars", fontSize = 12.sp) } // Shorter label
        )
        BottomNavigationItem(
            selected = currentRoute == Screen.Episodes.route,
            onClick = { navController.navigate(Screen.Episodes.route) },
            icon = { Icon(Icons.Default.DateRange, contentDescription = "Episodes") },
            label = { Text("Eps", fontSize = 12.sp) } // Shorter label
        )
        BottomNavigationItem(
            selected = currentRoute == Screen.SearchCharacters.route,
            onClick = { navController.navigate(Screen.SearchCharacters.route) },
            icon = { Icon(Icons.Default.Search, contentDescription = "Search Chars") },
            label = { Text("Search Chars", fontSize = 12.sp) } // Shorter label
        )
        BottomNavigationItem(
            selected = currentRoute == Screen.SearchEpisodes.route,
            onClick = { navController.navigate(Screen.SearchEpisodes.route) },
            icon = { Icon(Icons.Default.Search, contentDescription = "Search Eps") },
            label = { Text("Search Eps", fontSize = 12.sp) } // Shorter label
        )
    }
}