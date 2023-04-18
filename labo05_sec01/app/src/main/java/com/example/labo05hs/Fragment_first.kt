package com.example.labo05hs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Fragment_first : Fragment() {
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var CardView: CardView
    private lateinit var Button: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View{
        return inflater.inflate(R.layout.fragment_first,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        bindFloating()
        bindCard()
        bindButton()
        floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_first_to_fragment_third)
        }

        CardView.setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_first_to_fragment_second)
        }

        Button.setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_third_to_fragment_first2)
        }
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