package com.example.crudbiblioteca.config

class config {
    /*
    Se crea una rl static para consultar sin instanciar
    método companion object sirve para almacenar las variables static
     */
    companion object{
        val urlBase="http://10.192.66.24:8000/"
        val urlLibro=urlBase+"libro/"
    }
}