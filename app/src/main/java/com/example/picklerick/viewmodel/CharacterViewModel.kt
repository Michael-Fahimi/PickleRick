package com.example.picklerick.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.picklerick.data.model.Character
import com.example.picklerick.data.model.Episode
import com.example.picklerick.data.api.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    private val _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> = _episodes

    private val _currentCharacterPage = MutableStateFlow(1)
    val currentCharacterPage: StateFlow<Int> = _currentCharacterPage

    private val _totalCharacterPages = MutableStateFlow(1)
    val totalCharacterPages: StateFlow<Int> = _totalCharacterPages

    private val _currentEpisodePage = MutableStateFlow(1)
    val currentEpisodePage: StateFlow<Int> = _currentEpisodePage

    private val _totalEpisodePages = MutableStateFlow(1)
    val totalEpisodePages: StateFlow<Int> = _totalEpisodePages

    fun fetchAllCharacters() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getAllCharacters(_currentCharacterPage.value)
                _characters.value = response.results
                _totalCharacterPages.value = response.info.pages
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchAllEpisodes() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getAllEpisodes(_currentEpisodePage.value)
                _episodes.value = response.results
                _totalEpisodePages.value = response.info.pages
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadNextCharacterPage() {
        if (_currentCharacterPage.value < _totalCharacterPages.value) {
            _currentCharacterPage.value++
            fetchAllCharacters()
        }
    }

    fun loadPreviousCharacterPage() {
        if (_currentCharacterPage.value > 1) {
            _currentCharacterPage.value--
            fetchAllCharacters()
        }
    }

    fun loadNextEpisodePage() {
        if (_currentEpisodePage.value < _totalEpisodePages.value) {
            _currentEpisodePage.value++
            fetchAllEpisodes()
        }
    }

    fun loadPreviousEpisodePage() {
        if (_currentEpisodePage.value > 1) {
            _currentEpisodePage.value--
            fetchAllEpisodes()
        }
    }


    fun searchCharacters(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.searchCharacters(query)
                _characters.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchEpisodes(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.searchEpisodes(query)
                _episodes.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}