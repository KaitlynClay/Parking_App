package com.example.parking_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var mealCost: Int = 0
    var totCharge: Double = 0.00
    var tipChoice = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meal: EditText = findViewById(R.id.idMealCost)
        val group: Spinner = findViewById(R.id.idSpinGroup)
        val charges: Button = findViewById(R.id.idbtnCalc)
        val result: TextView = findViewById(R.id.idTxtResult)

        charges.setOnClickListener {
            mealCost = meal.text.toString().toInt()
            val currency = DecimalFormat("$###,###.00")
            tipChoice = group.selectedItem.toString()
            when(tipChoice){
                "5%"-> totCharge = 1.05 * mealCost.toDouble()
                "10%" -> totCharge = 1.10 * mealCost.toDouble()
                "15%" -> totCharge = 1.15 * mealCost.toDouble()
                "20%" -> totCharge = 1.20 * mealCost.toDouble()
                "25%" -> totCharge = 1.25 * mealCost.toDouble()
            }

            val totChargesFormat = currency.format(totCharge)

            result.text = "Total cost for meal, including tip: $totChargesFormat"



        }
    }
}