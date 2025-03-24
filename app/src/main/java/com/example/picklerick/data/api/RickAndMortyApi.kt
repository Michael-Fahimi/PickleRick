package com.example.picklerick.data.api

import com.example.picklerick.data.model.CharacterResponse
import com.example.picklerick.data.model.EpisodeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): CharacterResponse

    @GET("episode")
    suspend fun getAllEpisodes(@Query("page") page: Int): EpisodeResponse

    @GET("character/")
    suspend fun searchCharacters(@Query("name") name: String): CharacterResponse

    @GET("episode/")
    suspend fun searchEpisodes(@Query("name") name: String): EpisodeResponse
}