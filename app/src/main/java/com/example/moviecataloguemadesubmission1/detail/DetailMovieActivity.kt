package com.example.moviecataloguemadesubmission1.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.moviecataloguemadesubmission1.R
import com.example.moviecataloguemadesubmission1.core.domain.model.Movie
import com.example.moviecataloguemadesubmission1.databinding.ActivityDetailMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val movieDetails = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showMovieDetails(movieDetails)
    }

    private fun showMovieDetails(movieDetails: Movie?) {
        movieDetails?.let {
            supportActionBar?.title = it.title
            with(binding.content) {
                tvTitle.text = it.title
                tvOriginalTitle.text = it.originalTitle
                tvReleaseDate.text = it.releaseDate
            }
            with(binding) {
                Glide.with(applicationContext)
                    .load("https://image.tmdb.org/t/p/w500${it.backdropPath}")
                    .into(ivBackdrop)

                Glide.with(applicationContext)
                    .load("https://image.tmdb.org/t/p/w500${it.posterPath}")
                    .into(ivPoster)
            }
            var favoriteStatus = it.isFavorite
            setFavoriteStatus(favoriteStatus)
            binding.fab.setOnClickListener {
                favoriteStatus = !favoriteStatus
                detailMovieViewModel.setFavoriteMovie(movieDetails, favoriteStatus)
                setFavoriteStatus(favoriteStatus)
            }
        }
    }

    private fun setFavoriteStatus(favoriteStatus: Boolean) {
        if (favoriteStatus) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_red_24dp
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_black_24dp
                )
            )
        }
    }
}