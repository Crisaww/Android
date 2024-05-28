package com.example.mockuptaller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)
        btnCerrarSesion.setOnClickListener{
            /*
            finish elimina o cierra la activity actual
             */
            finish()
        }
    }
    fun cambioComoUsar(view: View){
        //se configura el cambio activity
        var intent= Intent(application, MainActivity3::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }

    fun QuienesSomos(view: View){
        //se configura el cambio activity
        var intent= Intent(application, MainActivity4::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }



}