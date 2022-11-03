package com.example.parcialtp3grupo4.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.parcialtp3grupo4.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var btnContinuar: Button
    lateinit var txtName: TextInputEditText
    lateinit var txtLastName: TextInputEditText
    private lateinit var name: String
    private lateinit var passwd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnContinuar = findViewById(R.id.btn_continuar)
        txtName = findViewById(R.id.editTextName)
        txtLastName = findViewById(R.id.editTextPasswod)

        btnContinuar.setOnClickListener {
            name = txtName.text.toString()
            passwd = txtLastName.text.toString()

            //Agregamos validación
            when {
                name.isEmpty() || passwd.isEmpty() -> {
                    Toast.makeText(this, "Los campos son obligatorios", Toast.LENGTH_SHORT)
                        .show()
                }
                else -> {
                    Toast.makeText(this, "Access Success", Toast.LENGTH_SHORT)
                        .show()

                    startActivity(Intent(this, HomeActivity::class.java))

                    //Ponemos el finish para impedir que vuelvan al login, tema de seguridad
                    finish()
                }
            }
        }
    }
}