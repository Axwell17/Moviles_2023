package com.example.labo05hs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labo05hs.R
import com.example.labo05hs.databinding.ActivityMainBinding
import com.example.labo05hs.databinding.FragmentThirdBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

