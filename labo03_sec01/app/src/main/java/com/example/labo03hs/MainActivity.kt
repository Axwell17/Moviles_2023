package com.example.labo03hs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var five_cents: ImageView
    private lateinit var ten_cents: ImageView
    private lateinit var quarter: ImageView
    private lateinit var one_dollar:ImageView
    private lateinit var number: TextView

    private var total: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_main)

        five_cents = findViewById(R.id.image_5_cents)
        ten_cents = findViewById(R.id.image_10_cents)
        quarter = findViewById(R.id.image_25_cents)
        one_dollar = findViewById(R.id.image_one_dollar)

        number = findViewById(R.id.numberText)

        listener()


    }

    private fun listener(){
        five_cents.setOnClickListener {
            total += 0.05
            var round = (total*1000.0).roundToInt().toDouble()/1000.0
            number.text = round.toString()
        }
        ten_cents.setOnClickListener {
            total += 0.10
            var round = (total*1000.0).roundToInt().toDouble()/1000.0
            number.text = round.toString()
        }
        quarter.setOnClickListener {
            total += 0.25
            var round = (total*1000.0).roundToInt().toDouble()/1000.0
            number.text = round.toString()
        }
        one_dollar.setOnClickListener {
            total += 1.00
            var round = (total*1000.0).roundToInt().toDouble()/1000.0
            number.text = round.toString()
        }
    }

}