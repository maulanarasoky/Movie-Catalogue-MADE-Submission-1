package com.example.moviecataloguemadesubmission1.core.domain.usecase

import com.example.moviecataloguemadesubmission1.core.data.Resource
import com.example.moviecataloguemadesubmission1.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovies(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovies(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}