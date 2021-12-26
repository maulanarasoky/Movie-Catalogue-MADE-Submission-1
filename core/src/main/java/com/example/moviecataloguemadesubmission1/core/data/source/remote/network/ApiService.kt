package com.example.moviecataloguemadesubmission1.core.data.source.remote.network

import com.example.moviecataloguemadesubmission1.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-Us"
    ): ListMovieResponse
}