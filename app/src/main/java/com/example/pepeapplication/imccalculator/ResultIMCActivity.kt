package com.example.pepeapplication.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pepeapplication.R
import com.example.pepeapplication.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var buttonRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val imc = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents()
        initUI(imc)
    }

    private fun initUI(imc:Double) {
        tvIMC.text = imc.toString()
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        buttonRecalculate = findViewById(R.id.btnRecalculate)
    }
}