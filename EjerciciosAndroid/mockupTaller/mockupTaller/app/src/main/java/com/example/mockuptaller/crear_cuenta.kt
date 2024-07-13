package com.example.mockuptaller

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class crear_cuenta: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.crear_cuenta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun iniciarSesion(view: View){
        val intent = Intent(this, iniciar_sesion::class.java)
        startActivity(intent)
    }
    fun registrarse(view: View) {
        //se configura el cambio activity
        var intent = Intent(application, inicio_pagina::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }
}