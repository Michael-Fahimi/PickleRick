package com.example.picklerick.ui.screen


import androidx.compose.foundation.Image
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
import coil.compose.rememberAsyncImagePainter
import com.example.picklerick.data.model.Character
import com.example.picklerick.viewmodel.CharacterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen(viewModel: CharacterViewModel) {
    val characters by viewModel.characters.collectAsState()
    val currentPage by viewModel.currentCharacterPage.collectAsState()
    val totalPages by viewModel.totalCharacterPages.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAllCharacters()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Characters", color = MaterialTheme.colorScheme.onPrimary)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    IconButton(
                        onClick = { viewModel.loadPreviousCharacterPage() },
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
                        onClick = { viewModel.loadNextCharacterPage() },
                        enabled = currentPage < totalPages
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next Page", tint = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(characters) { character ->
                CharacterItem(character)
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = character.image),
                contentDescription = character.name,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = character.name, style = MaterialTheme.typography.headlineSmall)
                Text(text = "Status: ${character.status}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Species: ${character.species}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}