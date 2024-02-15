package com.hamv.modulo4.tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.hamv.modulo4.R
import com.hamv.modulo4.intent.IntentReceiveExtrasActivity
import com.hamv.modulo4.tarea.entity.Usuario

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        //Generación de objeto para almacennar los datos del registro
        var usuario = Usuario("","", null, -1, "", "")
        var idGenero: Int = -1
        //Obtener la referencia del botón y el radio group
        val btnRegistrar = findViewById<Button>(R.id.btnNextRegPer)
        val rgGenero = findViewById<RadioGroup>(R.id.generoPersonaRegisto)

        //Detectar el evento de seleccion de radio button a traves del radio group
        rgGenero.setOnCheckedChangeListener { group, checkedId ->
            idGenero = when(checkedId){
                R.id.rbGeneroFemenidoRegisto -> 1
                R.id.rbGeneroMasculinoRegisto -> 2
                R.id.rbGeneroNoEspecificaRegisto -> 3
                else -> -1
            }
        }

        btnRegistrar.setOnClickListener {
            //Obtener referencia de los elementos visuales
            val nombrePersona = findViewById<EditText>(R.id.nombrePersonaRegisto).text.trim()
            val primerApellido = findViewById<EditText>(R.id.primerApellidoPersonaRegisto).text.trim()
            val segundoApellido = findViewById<EditText>(R.id.segundoApelidoPersonaRegisto).text.trim()
            val correoElectronico = findViewById<EditText>(R.id.etCorreoElectronico).text.trim()
            val password = findViewById<EditText>(R.id.etPassword).text.trim()
            val confirmPassword = findViewById<EditText>(R.id.etPasswordConfirm).text.trim()



            //Validar que los campos obligatorios se hayan ingresado
            if (nombrePersona.isEmpty() || primerApellido.isEmpty() || idGenero == -1 || correoElectronico.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ){
                Toast.makeText(this, "Por favor complete los campos marcados con *. ", Toast.LENGTH_SHORT).show()
            }else{
                //Validar que las contraseñas coincidan
                if (password.equals(confirmPassword)){
                    //las contraseñas coinciden, procede a setear propiedades en entidad usuario
                    usuario.nombre= nombrePersona.toString()
                    usuario.primerApellido = primerApellido.toString()
                    usuario.segundoApellido = segundoApellido?.toString()
                    usuario.genero = idGenero
                    usuario.email = correoElectronico.toString()
                    usuario.password = password.toString()
                    //Creación del listenner para detectar el click del botón
                    val sendIntent = Intent(this, ConfirmaRegistroActivity::class.java).apply {
                        putExtra("EXTRA_USUARIO", usuario)
                    }
                    //Inicia la actividad sin esperar respuesta
                    startActivity(sendIntent)
                }else{
                    //Contraseñas no coinciden
                    Toast.makeText(this, "Las contraseñas no coinciden, por favor verifique.", Toast.LENGTH_LONG).show()
                }

            }

        }




    }
}