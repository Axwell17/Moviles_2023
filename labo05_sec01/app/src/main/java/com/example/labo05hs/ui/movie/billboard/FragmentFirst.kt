package com.example.labo05hs.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.labo05hs.R
import com.example.labo05hs.databinding.FragmentThirdBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentFirst : Fragment() {
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var CardView: CardView
    private lateinit var Button: Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_first,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        bindFloating()
        bindCard()

        floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_first_to_fragment_third)
        }

        CardView.setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_first_to_fragment_second)
        }

//        Button.setOnClickListener {
//            it.findNavController().navigate(R.id.action_fragment_third_to_fragment_first)
//        }

    }

    private fun bindFloating(){
        floatingActionButton = view?.findViewById(R.id.floatingActionButton) as FloatingActionButton
    }

    private fun bindCard(){
        CardView = view?.findViewById(R.id.cardView) as CardView
    }

    private fun bindButton(){
        Button = view?.findViewById(R.id.button) as Button
    }
}