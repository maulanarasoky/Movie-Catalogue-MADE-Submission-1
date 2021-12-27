package com.example.moviecataloguemadesubmission1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviecataloguemadesubmission1.core.domain.usecase.MovieUseCase

class FavoriteViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    val favoriteMovies = movieUseCase.getFavoriteMovies().asLiveData()
}