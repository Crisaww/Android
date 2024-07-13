package com.example.mockuptaller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inicio_pagina: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.inicio_pagina)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var cerrarSesion = findViewById<ImageView>(R.id.cerrarSesion)
        cerrarSesion.setOnClickListener{
            /*
            finish elimina o cierra la activity actual
             */
            finish()
        }
    }

    fun frasesYPalabras(view: View) {
        //se configura el cambio activity
        var intent = Intent(application, frases_y_palabras::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }

    fun quienesSomos(view: View) {
        //se configura el cambio activity
        var intent = Intent(application, quienes_somos::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }

    fun manual(view: View) {
        //se configura el cambio activity
        var intent = Intent(application, como_usar_tuvooz::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }

    fun escribir(view: View) {
        //se configura el cambio activity
        var intent = Intent(application, texto::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }

    fun configuracion(view: View) {
        //se configura el cambio activity
        var intent = Intent(application, ventana_emergente::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }



}