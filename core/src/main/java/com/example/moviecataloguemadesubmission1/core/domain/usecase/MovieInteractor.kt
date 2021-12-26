package com.example.moviecataloguemadesubmission1.core.domain.usecase

import com.example.moviecataloguemadesubmission1.core.data.Resource
import com.example.moviecataloguemadesubmission1.core.domain.model.Movie
import com.example.moviecataloguemadesubmission1.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getAllMovies(): Flow<Resource<List<Movie>>> = movieRepository.getAllMovies()

    override fun getFavoriteMovies(): Flow<List<Movie>> = movieRepository.getFavoriteMovies()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)
}