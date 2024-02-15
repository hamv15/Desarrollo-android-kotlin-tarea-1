package com.hamv.modulo4.tarea

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import com.hamv.modulo4.R
import com.hamv.modulo4.intent.Auto
import com.hamv.modulo4.tarea.entity.Usuario

class ConfirmaRegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirma_registro)

        //Obtener referencias de objetos en la vista
        val contenidoRegistro = findViewById<TextView>(R.id.contenidoRegistrado)
        var genero: String = ""
        //Obtener referencia de los elementos visuales
        val persona =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                intent.getSerializableExtra("EXTRA_USUARIO", Usuario::class.java);
            }else{
                intent.getSerializableExtra("EXTRA_USUARIO") as Usuario;
            }
        //Obtención del género a través del id
        if (persona?.genero == 1){
            genero="Femenino"
        }else if (persona?.genero == 2){
            genero="Masculino"
        }else if (persona?.genero == 3){
            genero="No especificado"
        }else{
            genero="Desconocido"
        }
        //Mostrar los datos en el textView
        contenidoRegistro.text = "Se ha registrado a ${persona?.nombre} ${persona?.primerApellido} ${persona?.segundoApellido ?: ""} especificando el género: ${genero} y correo electrónico: ${persona?.email}"

    }
}