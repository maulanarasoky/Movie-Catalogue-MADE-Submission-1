package com.example.moviecataloguemadesubmission1.di

import com.example.moviecataloguemadesubmission1.core.domain.usecase.MovieInteractor
import com.example.moviecataloguemadesubmission1.core.domain.usecase.MovieUseCase
import com.example.moviecataloguemadesubmission1.detail.DetailMovieViewModel
import com.example.moviecataloguemadesubmission1.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}