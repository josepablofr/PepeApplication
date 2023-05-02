package com.example.pepeapplication.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.pepeapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat


class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvWeight: TextView
    private lateinit var buttonMinusWeight: FloatingActionButton
    private lateinit var buttonPlusWeight: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var buttonMinusAge: FloatingActionButton
    private lateinit var buttonPlusAge: FloatingActionButton
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var buttonCalculate: Button

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var weight: Int = 60
    private var age: Int = 30
    private var height: Int = 120

    companion object{
        const val IMC_KEY = "IMC RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.cvMale)
        viewFemale = findViewById(R.id.cvFemale)
        buttonMinusWeight = findViewById(R.id.btnMinusWeight)
        buttonPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        buttonMinusAge = findViewById(R.id.btnMinusAge)
        buttonPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        buttonCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        buttonMinusWeight.setOnClickListener {
            weight -= 1
            setWeight()
        }
        buttonPlusWeight.setOnClickListener {
            weight += 1
            setWeight()
        }
        buttonMinusAge.setOnClickListener {
            age -= 1
            setAge()
        }
        buttonPlusAge.setOnClickListener {
            age += 1
            setAge()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            height = df.format(value).toInt()
            tvHeight.text = "$height cm"
        }
        buttonCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if(isSelectedComponent) {
            R.color.app_background
        } else {
            R.color.app_background_selected
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun setWeight() {
        tvWeight.text = weight.toString()
    }

    private fun setAge() {
        tvAge.text = age.toString()
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat ("#.##")
        val imc = weight / (height.toDouble()/100 * height.toDouble() / 100)
        val result = df.format(imc).toDouble()
        return result
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent (this, ResultIMCActivity::class.java )
        intent.putExtra(IMC_KEY,result)
        startActivity(intent)
    }

    private fun initUI() {
        setGenderColor()
    }
}