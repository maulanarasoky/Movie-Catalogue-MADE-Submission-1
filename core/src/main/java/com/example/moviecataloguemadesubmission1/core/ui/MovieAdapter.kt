package com.example.moviecataloguemadesubmission1.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecataloguemadesubmission1.core.R
import com.example.moviecataloguemadesubmission1.core.databinding.ItemListMovieBinding
import com.example.moviecataloguemadesubmission1.core.domain.model.Movie

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false))

    override fun onBindViewHolder(holder: MovieAdapter.ListViewHolder, position: Int) {
        val movie = listData[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        fun bind(data: Movie) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${data.posterPath}")
                    .into(ivItemImage)

                tvItemTitle.text = data.title
                val ratings = (data.voteAverage / 2).toFloat()
                rbItem.rating = ratings
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}