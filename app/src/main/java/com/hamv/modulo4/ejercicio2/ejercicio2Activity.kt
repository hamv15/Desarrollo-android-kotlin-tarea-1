package com.hamv.modulo4.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamv.modulo4.R
import com.hamv.modulo4.ejercicio2.recyclerautos.Auto
import com.hamv.modulo4.ejercicio2.recyclerautos.AutoAdapter

class ejercicio2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
        //Crear referencia del recycler view
        val autoList = findViewById<RecyclerView>(R.id.rvSeleccionaAuto)

        //Variable para almacenar el pais seleccionado por el usuario
        var idPaisSeleccionado: Int = 0;
        var autoSeleccionado: Auto = Auto("","","")

        //Obtener la referencia de los elementos de la UI
        var rgGenere = findViewById<RadioGroup>(R.id.generoPersona)
        var spNacionalidad = findViewById<Spinner>(R.id.spinnerNacionalidad)
        var cbAvisoPrivacidad = findViewById<CheckBox>(R.id.cbAvisoPrivacidad)
        var btnSiguiente = findViewById<Button>(R.id.btnNextRegPer)

        //Lista de datos para llenar el Spinner
        var datosSpinner = arrayListOf("Colombia", "Chile", "Argentina", "México","Ecuador", "Guatemala", "El Salvador")

        //Creación de lista a mostrar en el recyclerView
        val autosDataList = arrayListOf(
            Auto("Ford", "Mustang", "2020"),
            Auto("Ford", "Focus", "2015"),
            Auto("Ford", "Ecosport", "2018"),
            Auto("Toyota", "Camry", "2015"),
            Auto("Chevrolet", "Camaro", "2014"),
            Auto("Kia", "Rio", "2019"),
            Auto("Kia", "Forte", "2018"),
        )

        //Detectar el evento de seleccion de radio button a traves del radio group
        rgGenere.setOnCheckedChangeListener { group, checkedId ->
            val idGnere = when(checkedId){
                R.id.rbGeneroFemenido -> "Femenino"
                R.id.rbGeneroMasculino -> "Masculino"
                R.id.rbGeneroNoEspecifica -> "Sin especificar"
                else -> "Desconocido"
            }
            Toast.makeText(this, "Valor del checkbox = $idGnere", Toast.LENGTH_LONG).show()
        }

        //Adapter para inicializar para asignar la colección de datos al spinner
        ArrayAdapter(this, android.R.layout.simple_spinner_item, datosSpinner).also {
            //Método para asignar el diseño a toda la lista
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spNacionalidad.adapter = it
        }

        //Implementación de interfaces anónimas para atrapar evento al seleccionar elemento del spinner
        spNacionalidad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = datosSpinner[position]
                idPaisSeleccionado = position
                Toast.makeText(this@ejercicio2Activity, "Valor seleccionado = $itemSelected", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@ejercicio2Activity, "Nada seleccionado", Toast.LENGTH_LONG).show()
            }

        }
        //

        //Detectar el evento de marcar/desmarcar el checkbox
        cbAvisoPrivacidad.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this,"¿Acepta aviso de privacidad? = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //Generar instancia del adapter
        val adapterAutos = AutoAdapter(autosDataList)

        //Evento de selección del adapter
        adapterAutos.onItemSelected = {
            autoSeleccionado=it
            Toast.makeText(this, "User selected = ${it.modelo}", Toast.LENGTH_LONG).show()
        }

        autoList.adapter = adapterAutos

        //LayOut manager nos va a decir como va mostrar los elementos
        autoList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Agregar acción de botón siguiente
        btnSiguiente.setOnClickListener {
            //Obtener el valor del radio group
            val rbSelecter = when(rgGenere.checkedRadioButtonId){
                R.id.rbGeneroFemenido -> "M"
                R.id.rbGeneroMasculino -> "H"
                R.id.rbGeneroNoEspecifica -> "SE"
                else -> "D"
            }
            //Obtener el valor del spinner
            val spinnerSelected = spNacionalidad.onItemSelectedListener
            //Obtener estado del checkBox
            val cbAvisoStatus = cbAvisoPrivacidad.isChecked

            //Mostrar valores en toast
            Toast.makeText(this, "Valor genero: $rbSelecter Valor spinner: ${datosSpinner[idPaisSeleccionado]} El auto seleccionado es ${if (autoSeleccionado.modelo != "") autoSeleccionado.modelo else "No seleccionó auto"} Aviso de privacidad: ${if (cbAvisoStatus) "Aceptado" else "Rechazado"}", Toast.LENGTH_LONG).show()
        }
    }


}