package com.example.recyclerviewempleado

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewempleado.adapters.adapterEmployed
import com.example.recyclerviewempleado.models.employed

class MainActivity : AppCompatActivity() {
    lateinit var listemployed:MutableList<employed>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Se inicializa el mutablelist
        listemployed= mutableListOf()
        //var employed=employed("Carlos", "Instructor")
        //listemployed.add(employed)
        listemployed.add(employed("Julian", "Desarrollador"))
        listemployed.add(employed("Mar", "Aprendiz"))
        listemployed.add(employed("Maria", "Aprendiz"))
        listemployed.add(employed("Mayra", "Ing. de Sistemas"))
        listemployed.add(employed("Isabella", "Ing. de Software"))
        listemployed.add(employed("Jeronimo", "Aprendiz"))
        listemployed.add(employed("Carlos", "Aprendiz"))
        listemployed.add(employed("Julio", "Aprendiz"))
        listemployed.add(employed("Leonel", "Aprendiz"))
        listemployed.add(employed("Cristiano", "Aprendiz"))

        //Se crea y asocia una variable con el objeto de la vista :)
        var recycler=findViewById<RecyclerView>(R.id.RVEmployed)
        recycler.layoutManager= LinearLayoutManager(applicationContext)
        //Se crea el adaptador
        var adapterEmployed=adapterEmployed(listemployed, applicationContext)
        //Se asocia el adaptador con el objeto
        recycler.adapter=adapterEmployed


    }
}