package com.example.crudbiblioteca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.crudbiblioteca.config.config
import com.example.crudbiblioteca.models.libro
import com.google.gson.Gson
//import com.google.gson.JsonObject //Genera error
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [guardarLibroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class guardarLibroFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    //Se definen las variables del formulario
    private lateinit var txtTitulo:EditText
    private lateinit var txtAutor:EditText
    private lateinit var txtGenero:EditText
    private lateinit var txtIsbn:EditText
    private lateinit var txtDisponibles:EditText
    private lateinit var txtOcupados:EditText
    private lateinit var btnGuardar: Button
    //De manera temporal se asigna un id
    private var id:Int=0

    /*
    Request: Es la petición que se hace a la api
    StringRequest: Responde un String
    JsonRequest: Responde un Json
    JsonArrayRequest: Responde un arreglo Json
     */

    /*
    Método encargado de traer la info del libro
     */

    fun actualizarLibro(){
        
    }
    fun consultarLibro(){
        /*
        Solo se debe consultar, si el ID es diferente a vacío
         */
        if(id!=0){

            var request=JsonObjectRequest(
                Request.Method.GET, //Método de la petición
                config.urlLibro+id, //Url
                null,//Parametros
                {response->
                val gson= Gson()
                    //Se convierte
                    val libro:libro=gson.fromJson(response.toString(), libro::class.java)
                    //Se modifica el atributo text de los campos con el valor del objeto
                    txtTitulo.setText(response.getString("titulo"))
                    txtAutor.setText(response.getString("autor"))
                    txtIsbn.setText(response.getString("isbn"))
                    txtGenero.setText(response.getString("genero"))
                    txtDisponibles.setText(response.getInt("num_ejem_disponibles").toString())
                    txtOcupados.setText(response.getInt("num_ejem_ocupados").toString())
                }, //Respuesta correcta
                {error->
                    Toast.makeText(
                        context,
                        "Error al consultar",
                        Toast.LENGTH_LONG
                    ).show()
                } //Error en la petición
            )
            //Se crea la cola de trabajo y se añade la petición
            val queue=Volley.newRequestQueue(context)
            //Se añade la petición
            queue.add(request)
        }
    }




    fun guardarLibro(){
        try {
            if(id==0){ //Se crea el libro
                /*
               //Se crea la petición
               val request=object:StringRequest(
                   Request.Method.POST, //método de la de petición
                   config.urlLibro, //url de la petición
                   Response.Listener {
                       //Metodo que se ejecuta cuando la peticion es correcta
                                     Toast.makeText(
                                         context,
                                         "Se guardó correctamente",
                                         Toast.LENGTH_LONG
                                     ).show()
                   },
                   Response.ErrorListener {
                       //metodo que se ejecuta cuando la peticion da error
                       Toast.makeText(
                           context,"Error al guardar",
                           Toast.LENGTH_LONG
                       ).show()
                   }
               )
               {
                   //Se agregan los datos para la petición
                   override fun getParams(): MutableMap<String, String>{
                       var parametros=HashMap<String,String>()
                       /*
                        parametros.put("titulo",txtTitulo.text.toString())
                        parametros.put("autor",txtAutor.text.toString())
                        parametros.put("isbn",txtIsbn.text.toString())
                        parametros.put("genero",txtGenero.text.toString())
                        parametros.put("disponibles",txtDisponibles.text.toString())
                        parametros.put("ocupados",txtOcupados.text.toString())
                        //uno por cada dato que requiere
                         */
                       parametros.put("titulo",txtTitulo.text.toString())
                       parametros.put("nombre_autor",txtAutor.text.toString())
                       parametros.put("isbn",txtIsbn.text.toString())
                       parametros.put("genero",txtGenero.text.toString())
                       parametros.put("num_ejem_disponibles",txtDisponibles.text.toString())
                       parametros.put("num_ejem_ocupados",txtOcupados.text.toString())

                       return parametros


                   }
               }

    */
                var parametros=JSONObject()
                parametros.put("titulo",txtTitulo.text.toString())
                parametros.put("autor",txtAutor.text.toString())
                parametros.put("isbn",txtIsbn.text.toString())
                parametros.put("genero",txtGenero.text.toString())
                parametros.put("num_ejem_disponibles",txtDisponibles.text.toString())
                parametros.put("num_ejem_ocupados",txtOcupados.text.toString())
                //Uno por cada dato que se requiera

                var request=JsonObjectRequest(
                    Request.Method.POST, //método
                    config.urlLibro, //url
                    parametros, //Datos de la petición
                    {response->
                        Toast.makeText(
                            context,
                            "Se guardó correctamente",
                            Toast.LENGTH_LONG
                        ).show()
                    }, //Cuando la respuesta es correcta

                    {error->
                        Toast.makeText(
                            context,
                            "Se generó un error :(",
                            Toast.LENGTH_LONG
                        ).show()
                    } //Cuando es incorrecta
                )

                //Se crea la cola de trabajo y se añade la petición
                val queue=Volley.newRequestQueue(context)
                //Se añade la petición
                queue.add(request)

            }else{ //Se actualiza el libro

                var parametros=JSONObject()
                parametros.put("titulo",txtTitulo.text.toString())
                parametros.put("autor",txtAutor.text.toString())
                parametros.put("isbn",txtIsbn.text.toString())
                parametros.put("genero",txtGenero.text.toString())
                parametros.put("num_ejem_disponibles",txtDisponibles.text.toString())
                parametros.put("num_ejem_ocupados",txtOcupados.text.toString())

                var request=JsonObjectRequest(
                    Request.Method.PUT, //método
                    config.urlLibro +id + "/", //url
                    parametros, //Datos de la petición
                    {response->
                        Toast.makeText(
                            context,
                            "Se guardó correctamente",
                            Toast.LENGTH_LONG
                        ).show()
                    }, //Cuando la respuesta es correcta

                    { error ->
                        Toast.makeText(
                            context,
                            "Se generó un error :(",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                )

            //Se crea la cola de trabajo y se añade la petición
            val queue=Volley.newRequestQueue(context)
            //Se añade la petición
            queue.add(request)
        }

        }catch (error:Exception){
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(
            R.layout.fragment_guardar_libro, container, false)
        txtTitulo=view.findViewById(R.id.txtTitulo)
        txtAutor=view.findViewById(R.id.txtAutor)
        txtIsbn=view.findViewById(R.id.txtIsbn)
        txtGenero=view.findViewById(R.id.txtGenero)
        txtDisponibles=view.findViewById(R.id.txtDisponibles)
        txtOcupados=view.findViewById(R.id.txtOcupados)
        btnGuardar=view.findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener{guardarLibro()
        }

        var btnVolver:Button=findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener {
         
        }

        consultarLibro()
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment guardarLibroFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            guardarLibroFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}