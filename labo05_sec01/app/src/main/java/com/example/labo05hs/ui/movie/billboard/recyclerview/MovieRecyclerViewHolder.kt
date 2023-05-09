package com.example.labo05hs.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.labo05hs.data.model.MovieModel
import com.example.labo05hs.databinding.MovieItemBinding
import com.example.labo05hs.ui.movie.MovieViewModel

class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieViewModel) -> Unit){
        binding.textView3.text = movie.name
        binding.textView5.text = movie.qualification

        binding.cardView.setOnClickListener{
            clickListener(movie)
        }
    }
}