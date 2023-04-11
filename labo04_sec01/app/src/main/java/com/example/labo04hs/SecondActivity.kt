package com.example.labo04hs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    private lateinit var placeholderName: TextView
    private lateinit var placeholderMail: TextView
    private lateinit var placeholderNumber: TextView
    private lateinit var buttonShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        placeholderName = findViewById(R.id.placeholderName)
        placeholderMail = findViewById(R.id.placeholderMail)
        placeholderNumber = findViewById(R.id.placeholderNumber)
        buttonShare = findViewById(R.id.buttonShare)


        val name = intent.getStringExtra("Name".toString())
        val mail = intent.getStringExtra("Mail".toString())
        val number = intent.getStringExtra("Number".toString())

        placeholderName.text = name
        placeholderMail.text = mail
        placeholderNumber.text = number

        shareButton()

    }

    private fun shareButton(){
        var text = placeholderName.text.toString() + "\n"+placeholderMail.text.toString() + "\n"+placeholderNumber.text.toString()
        buttonShare.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,  text)
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "The title")
            startActivity(Intent.createChooser(shareIntent, "Share..."))
        }
    }
}