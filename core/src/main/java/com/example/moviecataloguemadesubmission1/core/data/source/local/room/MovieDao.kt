package com.example.moviecataloguemadesubmission1.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Query
import com.example.moviecataloguemadesubmission1.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE is_favorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>
}