package com.example.motupatluapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_page)

        var bmi = 0.0
        val calculateBtn = findViewById<Button>(R.id.calculate_btn)


        fun motuFound(){
            setContentView(R.layout.motu_result)
            val returnBtn = findViewById<Button>(R.id.return_home)
            val bmiText = findViewById<TextView>(R.id.bmi)
            bmiText.text = "BMI is $bmi"
            returnBtn.setOnClickListener{
                setContentView(R.layout.main_page)
            }
        }
        fun patluFound(){
            setContentView(R.layout.patlu_result)
            val returnBtn = findViewById<Button>(R.id.return_home)
            val bmiText = findViewById<TextView>(R.id.bmi)
            bmiText.text = "BMI is $bmi"
            returnBtn.setOnClickListener{
                setContentView(R.layout.main_page)
            }
        }
        fun gigaChadFound(){
            setContentView(R.layout.giga_chad_result)
            val returnBtn = findViewById<Button>(R.id.return_home)
            val bmiText = findViewById<TextView>(R.id.bmi)
            bmiText.text = "BMI is $bmi"
            returnBtn.setOnClickListener{
                setContentView(R.layout.main_page)
            }
        }


        calculateBtn.setOnClickListener {
            val weightEditor = findViewById<EditText>(R.id.weight_editor)
            val heightEditor = findViewById<EditText>(R.id.height_editor)
            val userWeight = weightEditor.text.toString().toFloat()
            val userHeight = (heightEditor.text.toString().toFloat())*0.0254 // Converting inch to meters
            bmi = userWeight/(userHeight * userHeight)
            bmi = String.format("%.1f", bmi).toDouble()
//            Toast.makeText(this, "Your BMI is $bmi", Toast.LENGTH_LONG).show()
            if (bmi < 18.5 ){
                patluFound()
            } else if (bmi > 18.5 && bmi < 25){
                gigaChadFound()
            } else {
                motuFound()
            }
        }
    }
}