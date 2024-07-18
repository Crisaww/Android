package com.example.mockuptaller

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class frases_y_palabras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.frases_y_palabras)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnVolver = findViewById<ImageView>(R.id.btnVolver)
        btnVolver.setOnClickListener{
            /*
            finish elimina o cierra la activity actual
             */
            finish()
        }
    }

    fun animales(view: View){
        val intent = Intent(this, frases_y_palabras_animales::class.java)
        startActivity(intent)
    }

    fun emociones(view: View){
        val intent = Intent(this, frases_y_palabras_emociones::class.java)
        startActivity(intent)
    }

    fun preguntas(view: View){
        val intent = Intent(this, frases_y_palabras_preguntas::class.java)
        startActivity(intent)
    }

    fun recientes(view: View){
        val intent = Intent(this, frases_y_palabras_recientes::class.java)
        startActivity(intent)
    }

    fun despedidas(view: View){
        val intent = Intent(this, frases_y_palabras_despedidas::class.java)
        startActivity(intent)
    }

    fun conectores(view: View){
        val intent = Intent(this, frases_y_palabras_conectores::class.java)
        startActivity(intent)
    }

    fun saludos(view: View){
        val intent = Intent(this, frases_y_palabras_saludos::class.java)
        startActivity(intent)
    }

    fun favoritos(view: View){
        val intent = Intent(this, frases_y_palabras_favoritos::class.java)
        startActivity(intent)
    }

}