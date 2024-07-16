package com.example.mockuptaller

import android.app.Dialog
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
       /* var intent = Intent(application, ventana_emergente::class.java)
        //se ejecuta la actividad
        startActivity(intent)
        */

        // Crear el AlertDialog
        /*val builder = AlertDialog.Builder(this)
        builder.setTitle("Título del AlertDialog")
        builder.setMessage("Mensaje del AlertDialog")
        builder.setPositiveButton("Aceptar") { dialog, which ->
            // Acción cuando el usuario presiona "Aceptar"
        }
        builder.setNegativeButton("Cancelar") { dialog, which ->
            // Acción cuando el usuario presiona "Cancelar"
        }

        // Mostrar el AlertDialog
        val dialog: AlertDialog = builder.create()
        dialog.show()*/

        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.ventana_emergente, null)

        // Crear el AlertDialog
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)

        // Configurar botones y acciones
        val dialog: AlertDialog = builder.create()

        // Obtener referencias a los botones del layout inflado
        val btnMiCuenta = dialogView.findViewById<Button>(R.id.btnMiCuenta)
        val btnAccesibilidad = dialogView.findViewById<Button>(R.id.btnAccesibilidad)
        val btnContrasena = dialogView.findViewById<Button>(R.id.btnContrasena)

        // Configurar acciones de los botones
        btnMiCuenta.setOnClickListener {
            // Acción cuando el usuario presiona "Mi cuenta"
        }

        btnAccesibilidad.setOnClickListener {
            // Acción cuando el usuario presiona "Accesibilidad"
        }

        btnContrasena.setOnClickListener {
            // Acción cuando el usuario presiona "Contraseña"
        }

        // Mostrar el AlertDialog
        dialog.show()

    }



}