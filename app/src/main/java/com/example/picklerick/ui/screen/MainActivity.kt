package com.example.picklerick.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.picklerick.ui.theme.PickleRickTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.picklerick.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PickleRickTheme { // Apply the custom theme
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RickAndMortyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RickAndMortyApp(modifier: Modifier = Modifier, viewModel: CharacterViewModel = viewModel()) {
    MainScreen(viewModel = viewModel, modifier = modifier)
}



