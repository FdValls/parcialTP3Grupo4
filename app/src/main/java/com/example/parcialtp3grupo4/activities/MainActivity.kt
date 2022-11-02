package com.example.parcialtp3grupo4.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.parcialtp3grupo4.R

class MainActivity : AppCompatActivity() {

    lateinit var btnContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnContinuar = findViewById(R.id.btn_continuar)

        btnContinuar.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}