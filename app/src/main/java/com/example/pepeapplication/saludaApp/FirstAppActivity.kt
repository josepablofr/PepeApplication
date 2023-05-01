package com.example.pepeapplication.saludaApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pepeapplication.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnPulsame = findViewById<Button>(R.id.btnPulsame)
        val etName = findViewById<TextView>(R.id.etName)

        btnPulsame.setOnClickListener {
            val name = etName.text.toString()

            if (name.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }
    }

}