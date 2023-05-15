package com.example.labo05hs.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labo05hs.R
import com.example.labo05hs.data.model.MovieModel
import com.example.labo05hs.databinding.FragmentFirstBinding
import com.example.labo05hs.databinding.FragmentSecondBinding
import com.example.labo05hs.databinding.FragmentThirdBinding
import com.example.labo05hs.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.labo05hs.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentFirst : Fragment() {
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var CardView: CardView
    private lateinit var Button: Button

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: MovieRecyclerViewAdapter
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)
        bindFloating()
        displayMovies()
        floatingActionButton.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_fragment_first_to_fragment_third)
        }

    }

    private fun bindFloating() {
        floatingActionButton = view?.findViewById(R.id.floatingActionButton) as FloatingActionButton
    }

    private fun bindCard() {
        CardView = view?.findViewById(R.id.cardView) as CardView
    }

    private fun bindButton() {
        Button = view?.findViewById(R.id.button) as Button
    }

    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_fragment_first_to_fragment_second)
    }

    private fun displayMovies() {
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie -> showSelectedItem(selectedMovie) }

        binding.recyclerView.adapter = adapter
        displayMovies()

    }
}


