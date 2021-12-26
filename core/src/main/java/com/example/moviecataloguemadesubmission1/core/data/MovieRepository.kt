package com.example.moviecataloguemadesubmission1.core.data

import com.example.moviecataloguemadesubmission1.core.data.source.local.LocalDataSource
import com.example.moviecataloguemadesubmission1.core.data.source.remote.RemoteDataSource
import com.example.moviecataloguemadesubmission1.core.data.source.remote.network.ApiResponse
import com.example.moviecataloguemadesubmission1.core.data.source.remote.response.MovieResponse
import com.example.moviecataloguemadesubmission1.core.domain.model.Movie
import com.example.moviecataloguemadesubmission1.core.domain.repository.IMovieRepository
import com.example.moviecataloguemadesubmission1.core.utils.AppExecutors
import com.example.moviecataloguemadesubmission1.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository{

    override fun getAllMovies(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovies().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovies(movieList)
            }

        }.asFlow()

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovies().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state) }
    }
}