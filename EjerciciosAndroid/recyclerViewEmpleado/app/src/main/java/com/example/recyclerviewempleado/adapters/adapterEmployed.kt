package com.example.recyclerviewempleado.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewempleado.R
import com.example.recyclerviewempleado.models.employed


/*
Esta clase es la encargada
 de cargar los datos al RecyclerView.

 Para instanciar la clase se requiere unos parámetros

 1. Lista elementos
 2. Contexto de la aplicación

 Esta clase debe heredar de la clase
 RecyclerView.Adapter
 Para heredar se utiliza ":" y la clase de donde se va a heredar
 */

class adapterEmployed
    (var listEmployed: List<employed>,
            var context:Context
            ):RecyclerView.Adapter<adapterEmployed.MyHolder>()

{
                /*
                Se crea la clase "MyHolder"
                 */
                inner class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
                    /*
                    Dentro de la clase MyHolder se crean la variables
                    y se asocian los objetos de la vista item
                     */
                    lateinit var lblName: TextView
                    lateinit var lblPosition: TextView
                    init {
                        lblName=itemView.findViewById(R.id.lblName)
                        lblPosition=itemView.findViewById(R.id.lblPosition)
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterEmployed.MyHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.item_employed,parent,false)
        return MyHolder (itemView)
    }

    override fun onBindViewHolder(holder: adapterEmployed.MyHolder, position: Int) {
        //Obtener el registro
        val employed=listEmployed[position]
        //Asignar Valores
        holder.lblName.text=employed.name
        holder.lblPosition.text=employed.position
    }

    //El método getItemCount: Retorna el número de elementos en la lista

    override fun getItemCount(): Int {
        return listEmployed.size
    }
}