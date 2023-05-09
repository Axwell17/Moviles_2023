package com.example.labo05hs.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labo05hs.data.model.MovieModel
import com.example.labo05hs.databinding.MovieItemBinding
import com.example.labo05hs.ui.movie.MovieViewModel

class MovieRecyclerViewAdapter (private val clickListener: (MovieViewModel) ->Unit): RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    private val movies = ArrayList<MovieModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)
    }
}