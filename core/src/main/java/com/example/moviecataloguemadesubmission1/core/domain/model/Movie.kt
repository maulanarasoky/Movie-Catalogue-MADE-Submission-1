package com.example.moviecataloguemadesubmission1.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var movieId: Int,
    var originalTitle: String,
    var overview: String,
    var releaseDate: String,
    var title: String,
    var voteAverage: Double,
    var backdropPath: String,
    var posterPath: String,
    var isFavorite: Boolean = false
): Parcelable