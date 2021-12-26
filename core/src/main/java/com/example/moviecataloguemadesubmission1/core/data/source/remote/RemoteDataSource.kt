package com.example.moviecataloguemadesubmission1.core.data.source.remote

import android.util.Log
import com.example.moviecataloguemadesubmission1.core.data.source.remote.network.ApiResponse
import com.example.moviecataloguemadesubmission1.core.data.source.remote.network.ApiService
import com.example.moviecataloguemadesubmission1.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAllMovies(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getAllMovies("6e749f65c71d141b805f8dda204de45b")
                val dataArray = response.result
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}