package com.example.mockuptaller

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class iniciar_sesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.iniciar_sesion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //Boton de Iniciar Sesion
    fun iniciarSesion(view: View) {
        //se configura
        var intent = Intent(application, inicio_pagina::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }

    fun olvidoContra(view: View) {
        //se configura el cambio activity
        var intent = Intent(application, recuperar_contra::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }

    fun crearCuenta(view: View) {
        //se configura el cambio activity
        var intent = Intent(application, crear_cuenta::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }

}