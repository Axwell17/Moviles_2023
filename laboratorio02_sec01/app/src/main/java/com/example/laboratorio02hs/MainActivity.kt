package com.example.laboratorio02hs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var numberEditText1: EditText
    private lateinit var numberEditText2: EditText
    private lateinit var resultTextView1: TextView
    private lateinit var resultTextView2: TextView
    private lateinit var resultTextView3: TextView
    private lateinit var button: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        setListener()
    }

    private fun binding(){
        numberEditText1 = findViewById(R.id.editText1)
        numberEditText2 = findViewById(R.id.editText2)
        resultTextView1 = findViewById(R.id.textView5)
        resultTextView2 = findViewById(R.id.textView6)
        resultTextView3 = findViewById(R.id.textView7)
        button = findViewById(R.id.button)

    }

    private fun setListener(){
        button.setOnClickListener{
            val number = numberEditText1.text.toString()
            val number2 = numberEditText2.text.toString()

            val function = number.toFloat()/((number2).toFloat()*(number2).toFloat()/10000)

            if(number.isNullOrEmpty()){
                Toast.makeText(this, "No hay dato", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            result(function)
        }

    }

    private fun result(number:Float){
        if(number <= 18.5){
            resultTextView1.text = number.toString()
            resultTextView2.text = "UnderWeight"
            resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.obese))
            resultTextView3.text = "Normal range is 18.5 - 24.99"
        }

        if(number >= 18.5 && number <= 24.99){
            resultTextView1.text = number.toString()
            resultTextView2.text = "Healthy"
            resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
            resultTextView3.text = "Normal range is 18.5 - 24.99"
        }

        if(number > 25 && number<=29.99 ){
            resultTextView1.text = number.toString()
            resultTextView2.text = "OverWeight"
            resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
            resultTextView3.text = "Normal range is 18.5 - 24.99"
        }

        if(number > 30 ){
            resultTextView1.text = number.toString()
            resultTextView2.text = "Obese"
            resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.obese))
            resultTextView3.text = "Normal range is 18.5 - 24.99"
        }

    }

}