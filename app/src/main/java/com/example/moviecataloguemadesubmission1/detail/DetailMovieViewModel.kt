package com.example.moviecataloguemadesubmission1.detail

import androidx.lifecycle.ViewModel
import com.example.moviecataloguemadesubmission1.core.domain.model.Movie
import com.example.moviecataloguemadesubmission1.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, state: Boolean) = movieUseCase.setFavoriteMovie(movie, state)
}