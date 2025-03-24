package com.example.picklerick.ui.screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.picklerick.viewmodel.CharacterViewModel

@Composable
fun SearchCharactersScreen(viewModel: CharacterViewModel) {
    var query by remember { mutableStateOf("") }
    val characters by viewModel.characters.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search Characters") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.searchCharacters(query) }) {
            Text("Search")
        }

        // Display search results
        LazyColumn {
            items(characters) { character ->
                CharacterItem(character)
            }
        }
    }
}


@Composable
fun SearchEpisodesScreen(viewModel: CharacterViewModel) {
    var query by remember { mutableStateOf("") }
    val episodes by viewModel.episodes.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search Episodes") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.searchEpisodes(query) }) {
            Text("Search")
        }

        // Display search results
        LazyColumn {
            items(episodes) { episode ->
                EpisodeItem(episode)
            }
        }
    }
}