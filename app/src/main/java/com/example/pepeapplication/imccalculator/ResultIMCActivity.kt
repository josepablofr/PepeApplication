package com.example.pepeapplication.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
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
        initListeners()
    }

    private fun initListeners() {
        buttonRecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(imc:Double) {
        tvIMC.text = imc.toString()
        when (imc) {
            in 0.00..18.50 -> {
                tvResult.text = getString(R.string.title_low_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.menu_colors))
                tvDescription.text = getString(R.string.description_low_weight)
            }
            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.title_normal_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.purple_200))
                tvDescription.text = getString(R.string.description_normal_weight)
            }
            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_obesity)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.app_background))
                tvDescription.text = getString(R.string.description_obesity)
            }
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_overweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.menu_colors))
                tvDescription.text = getString(R.string.description_overweight)
            }
            else -> {
                tvResult.text = "Error"
                tvIMC.text = "Error"
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.menu_colors))
                tvDescription.text = "Error"
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        buttonRecalculate = findViewById(R.id.btnRecalculate)
    }
}