package com.example.moviecataloguemadesubmission1.core.utils

import com.example.moviecataloguemadesubmission1.core.data.source.local.entity.MovieEntity
import com.example.moviecataloguemadesubmission1.core.data.source.remote.response.MovieResponse
import com.example.moviecataloguemadesubmission1.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id,
                originalTitle = it.originalTitle,
                overview = it.overview,
                releaseDate = it.releaseDate,
                title = it.title,
                voteAverage = it.voteAverage,
                backdropPath = it.backdropPath,
                posterPath = it.posterPath,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                originalTitle = it.originalTitle,
                overview = it.overview,
                releaseDate = it.releaseDate,
                title = it.title,
                voteAverage = it.voteAverage,
                backdropPath = it.backdropPath,
                posterPath = it.posterPath,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        originalTitle = input.originalTitle,
        overview = input.overview,
        releaseDate = input.releaseDate,
        title = input.title,
        voteAverage = input.voteAverage,
        backdropPath = input.backdropPath,
        posterPath = input.posterPath,
        isFavorite = input.isFavorite
    )
}