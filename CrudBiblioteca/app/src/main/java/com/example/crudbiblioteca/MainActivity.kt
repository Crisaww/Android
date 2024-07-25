package com.example.crudbiblioteca

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnRegistro:Button=findViewById(R.id.btnRegistrarLibro)
        btnRegistro.setOnClickListener { registrarLibros() }
    }

    fun registrarLibros() {
        // Obtener el FragmentManager del contexto actual
        val fragmentManager = supportFragmentManager // Usa `supportFragmentManager` si estás en una actividad

        // Crear una instancia del fragmento
        val fragmento = guardarLibroFragment() // Asegúrate de que `PaginaPrincipalFragment` es el nombre correcto del fragmento

        // Comenzar la transacción de fragmentos
        val transaction = fragmentManager.beginTransaction()

        // Reemplazar el fragmento actual con el nuevo fragmento
        transaction.replace(R.id.fragmentContainerView4, fragmento) // Asegúrate de que `R.id.fragmentContainerView` es el ID del contenedor en tu layout

        // Añadir la transacción al back stack si quieres permitir que el usuario regrese al fragmento anterior
        transaction.addToBackStack(null)

        // Confirmar los cambios
        transaction.commit()
    }









}