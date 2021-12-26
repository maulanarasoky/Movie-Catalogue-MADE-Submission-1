package com.example.moviecataloguemadesubmission1.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("original_title")
    val originalTitle: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("poster_path")
    val posterPath: String
)