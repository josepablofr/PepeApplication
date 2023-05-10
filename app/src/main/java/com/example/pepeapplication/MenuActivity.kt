package com.example.pepeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pepeapplication.imccalculator.ImcCalculatorActivity
import com.example.pepeapplication.saludaApp.FirstAppActivity
import com.example.pepeapplication.todoApp.ToDoActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSayHelloApp = findViewById<Button>(R.id.btnSayHelloApp)
        val btnCorporalWeight = findViewById<Button>(R.id.btnCorporalWeight)
        val btnToDoApp = findViewById<Button>(R.id.btnTodoApp)

        btnSayHelloApp.setOnClickListener { navigateToSayhelloApp() }
        btnCorporalWeight.setOnClickListener { navigateToCorporalWeightApp() }
        btnToDoApp.setOnClickListener { navigateToToDoApp() }
    }


    private fun navigateToSayhelloApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToCorporalWeightApp() {
        val intent = Intent (this, ImcCalculatorActivity::class.java )
        startActivity(intent)
    }

    private fun navigateToToDoApp() {
        val intent = Intent (this, ToDoActivity::class.java)
        startActivity(intent)
    }
}