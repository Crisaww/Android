package com.example.crudbiblioteca.config

class config {
    /*
    Se crea una rl static para consultar sin instanciar
    método companion object sirve para almacenar las variables static
     */
    companion object{
        //val urlBase="http://10.192.80.151:8080/api/v1/"
        //val urlBase="http://10.192.66.24:8000/api/v1/"
        val urlBase="http://192.168.1.8:8000/libreria/api/v1/"
        val urlLibro=urlBase+"libro/"
    }
}