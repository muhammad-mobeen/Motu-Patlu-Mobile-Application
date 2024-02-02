package com.example.motupatluapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
    }

    fun showResult(view: View){
        val weightEditor = findViewById<EditText>(R.id.weight_editor)
        val heightEditor = findViewById<EditText>(R.id.height_editor)
        val userWeightText = weightEditor.text.toString().trim()
        val userHeightText = heightEditor.text.toString().trim()
        val regex = Regex("[a-zA-Z]")   // For detecting alphabets in input fields


        if (userWeightText.isEmpty() or userHeightText.isEmpty()) {
            Toast.makeText(applicationContext, "Please fill all the fields!", Toast.LENGTH_LONG).show()
        } else if (regex.containsMatchIn(userWeightText) or regex.containsMatchIn(userHeightText)) {
            Toast.makeText(applicationContext, "Only numbers are allowed!", Toast.LENGTH_LONG).show()
        }
        else {
            val userWeight = userWeightText.toDouble()
            val userHeight = userHeightText.toDouble() * 0.0254 // Converting inch to meters
            var bmi = userWeight/(userHeight * userHeight)
            bmi = String.format("%.1f", bmi).toDouble()

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("bmi", bmi)
            }
            startActivity(intent)
        }

    }

}