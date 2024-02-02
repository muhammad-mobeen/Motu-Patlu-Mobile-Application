package com.example.motupatluapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val bmi = intent.getDoubleExtra("bmi", 0.0)
        if (bmi < 18.5 ){
            setContentView(R.layout.patlu_result)
            val bmiText = findViewById<TextView>(R.id.bmi)
            bmiText.text = "BMI is $bmi"
        } else if (bmi > 18.5 && bmi < 25){
            setContentView(R.layout.giga_chad_result)
            val bmiText = findViewById<TextView>(R.id.bmi)
            bmiText.text = "BMI is $bmi"
        } else {
            setContentView(R.layout.motu_result)
            val bmiText = findViewById<TextView>(R.id.bmi)
            bmiText.text = "BMI is $bmi"
        }

    }

    fun goBack(view: View) {
        onBackPressedDispatcher.onBackPressed()
    }

}