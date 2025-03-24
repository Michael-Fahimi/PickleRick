package com.example.picklerick.ui.navigation

// Navigation.kt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.picklerick.ui.screen.CharactersScreen
import com.example.picklerick.ui.screen.EpisodesScreen
import com.example.picklerick.ui.screen.SearchCharactersScreen
import com.example.picklerick.ui.screen.SearchEpisodesScreen
import com.example.picklerick.viewmodel.CharacterViewModel

sealed class Screen(val route: String) {
    object Characters : Screen("characters")
    object Episodes : Screen("episodes")
    object SearchCharacters : Screen("search_characters") // New route for character search
    object SearchEpisodes : Screen("search_episodes") // New route for episode search
}
@Composable
fun RickAndMortyNavHost(
    viewModel: CharacterViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Characters.route,
        modifier = modifier
    ) {
        composable(Screen.Characters.route) {
            CharactersScreen(viewModel)
        }
        composable(Screen.Episodes.route) {
            EpisodesScreen(viewModel)
        }
        composable(Screen.SearchCharacters.route) {
            SearchCharactersScreen(viewModel)
        }
        composable(Screen.SearchEpisodes.route) {
            SearchEpisodesScreen(viewModel)
        }
    }
}