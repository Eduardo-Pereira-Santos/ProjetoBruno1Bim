package com.example.calculodeimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val digitepeso = findViewById<EditText>(R.id.digitepeso)
        val digitealtura = findViewById<EditText>(R.id.digitealtura)
        val botaocalcular = findViewById<Button>(R.id.botaocalcular)
        val resultado = findViewById<TextView>(R.id.resultado)

        botaocalcular.setOnClickListener {
            calcularIMC(digitepeso, digitealtura, resultado)
        }
    }

    private fun calcularIMC(peso: EditText, altura: EditText, resultado: TextView) {
        val peso = peso.text.toString().toFloatOrNull()
        val altura = altura.text.toString().toFloatOrNull()

        if (peso != null && altura != null && altura > 0) {
            val IMC = peso / (altura * altura)
            resultado.text = "IMC: %.2f\n$IMC".format(IMC)
        } else {
            resultado.text = "Insira somente valores válidos!"
        }
    }
}