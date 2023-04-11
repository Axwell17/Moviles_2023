package com.example.labo04hs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: TextInputEditText
    private lateinit var editTextMail: TextInputEditText
    private lateinit var editTextNumber: TextInputEditText
    private lateinit var buttonSave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editName)
        editTextMail = findViewById(R.id.editMail)
        editTextNumber = findViewById(R.id.editNumber)



        saveInfo()



    }

    private fun saveInfo(){
        findViewById<Button>(R.id.buttonSave).setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Name", editTextName.text.toString())
            intent.putExtra("Mail", editTextMail.text.toString())
            intent.putExtra("Number", editTextNumber.text.toString())
            startActivity(intent)
        }
    }
}