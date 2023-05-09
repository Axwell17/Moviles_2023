package com.example.labo05hs.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.labo05hs.R
import com.example.labo05hs.databinding.FragmentThirdBinding
import com.example.labo05hs.ui.movie.MovieViewModel

class FragmentThird : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var editTextMovieName: EditText
    private lateinit var editTextCategory: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var editTextQualification: EditText
    private lateinit var Button: Button

    private lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        bindButton()
        bindEditText()
        setViewModel()
        observeStatus()
        var name = editTextMovieName.text.toString()
        var category = editTextCategory.text.toString()
        var description = editTextDescription.text.toString()
        var qualification = editTextQualification.text.toString()

        //Button.setOnClickListener{
        //    movieViewModel.addMovies(MovieModel(name,category,description,qualification))
        //    Log.d("Lista", movieViewModel.getMovies().toString())
        //}

    }

    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }

    private fun observeStatus(){
        movieViewModel.status.observe(viewLifecycleOwner) {status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun bindButton(){
        Button = view?.findViewById(R.id.button) as Button
        Button.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_third_to_fragment_first)
        }
    }

    private fun bindEditText(){
        editTextMovieName = view?.findViewById(R.id.editTextMovieName) as EditText
        editTextCategory = view?.findViewById(R.id.editTextCategory) as EditText
        editTextDescription = view?.findViewById(R.id.editTextDescription) as EditText
        editTextQualification = view?.findViewById(R.id.editTextQualification) as EditText
    }
}