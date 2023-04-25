package com.example.labo05hs.repositories

import com.example.labo05hs.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies
    fun addMovies(movie:MovieModel) = movies.add(movie)
}