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

class FragmentThird : Fragment() {
    private lateinit var Button: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View{
        return inflater.inflate(R.layout.fragment_third,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        bindButton()


        Button.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_third_to_fragment_first)
        }

    }


    private fun bindButton(){
        Button = view?.findViewById(R.id.button) as Button
    }
}