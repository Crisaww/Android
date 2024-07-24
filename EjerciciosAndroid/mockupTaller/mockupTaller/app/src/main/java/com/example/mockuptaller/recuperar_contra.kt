package com.example.mockuptaller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class recuperar_contra: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.recuperar_contra)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnVolver = findViewById<ImageView>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            /*
            finish elimina o cierra la activity actual
             */
            finish()
        }

        val btnEnviar: Button = findViewById(R.id.btnRecuperarContra)
        btnEnviar.setOnClickListener {
            mostrarAlerta()
        }
    }
        fun mostrarAlerta() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Correo Enviado")
            builder.setMessage("Por favor revise su bandeja de entrada.")
            builder.setPositiveButton("OK") { dialog, _ ->
                // Acción al hacer clic en OK
                dialog.dismiss()
            }

            val alerta = builder.create()
            alerta.show()
        }
}