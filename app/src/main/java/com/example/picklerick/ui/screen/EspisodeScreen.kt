package com.example.picklerick.ui.screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.picklerick.viewmodel.CharacterViewModel
import com.example.picklerick.data.model.Episode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodesScreen(viewModel: CharacterViewModel) {
    val episodes by viewModel.episodes.collectAsState()
    val currentPage by viewModel.currentEpisodePage.collectAsState()
    val totalPages by viewModel.totalEpisodePages.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAllEpisodes()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Episodes", color = MaterialTheme.colorScheme.onPrimary)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    IconButton(
                        onClick = { viewModel.loadPreviousEpisodePage() },
                        enabled = currentPage > 1
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous Page", tint = MaterialTheme.colorScheme.onPrimary)
                    }
                    Text(
                        text = "Page $currentPage of $totalPages",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    IconButton(
                        onClick = { viewModel.loadNextEpisodePage() },
                        enabled = currentPage < totalPages
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next Page", tint = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(episodes) { episode ->
                EpisodeItem(episode)
            }
        }
    }
}

@Composable
fun EpisodeItem(episode: Episode) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = episode.name, style = MaterialTheme.typography.headlineSmall)
            Text(text = "Episode: ${episode.episode}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}