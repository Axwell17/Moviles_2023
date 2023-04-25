package com.example.labo05hs

import android.app.Application
import com.example.labo05hs.data.movies
import com.example.labo05hs.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}