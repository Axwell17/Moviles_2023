package com.example.labo05hs.ui.movie

import android.media.audiofx.AudioEffect.Descriptor
import android.os.Bundle
import android.util.EventLogTags.Description
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.labo05hs.R
import com.example.labo05hs.data.model.MovieModel
import java.util.Locale.Category
import java.util.jar.Attributes.Name

class FragmentThird : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var editTextTextPersonName: EditText
    private lateinit var editTextTextCategory: EditText
    private lateinit var editTextTextDescription: EditText
    private lateinit var editTextTextCalification: EditText
    private lateinit var Button: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_third,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        bindButton()
        bindEditText()

        var name = editTextTextPersonName.text.toString()
        var category = editTextTextCategory.text.toString()
        var description = editTextTextDescription.text.toString()
        var calification = editTextTextCalification.text.toString()

        Button.setOnClickListener{
            movieViewModel.addMovies(MovieModel(name,category,description,calification))
            Log.d("Lista", movieViewModel.getMovies().toString())
        }



    }


    private fun bindButton(){
        Button = view?.findViewById(R.id.button) as Button
        Button.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_third_to_fragment_first)
        }
    }

    private fun bindEditText(){
        editTextTextPersonName = view?.findViewById(R.id.editTextTextPersonName) as EditText
        editTextTextCategory = view?.findViewById(R.id.editTextTextCategory) as EditText
        editTextTextDescription = view?.findViewById(R.id.editTextTextDescription) as EditText
        editTextTextCalification = view?.findViewById(R.id.editTextTextCalification) as EditText
    }
}