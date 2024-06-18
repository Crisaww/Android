package com.example.crudbiblioteca.models

data class libro(
    var id:Int,
    var titulo:String,
    var autor:String,
    var isbn:String,
    var genero:String,
    var num_ejem_disponibles:Int,
    var num_ejem_ocupados:Int
)
