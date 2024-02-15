package com.hamv.modulo4.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.hamv.modulo4.R

class ComponentSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_selection)
        //Obtener las referencias de los elementos de la UI
        val cbEstudiando = findViewById<CheckBox>(R.id.cbEstudiando)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        var rgGenere = findViewById<RadioGroup>(R.id.rgGenere)
        var spinner = findViewById<Spinner>(R.id.spinner)


        //Detectar el evento de marcar/desmarcar el checkbox
        cbEstudiando.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this,"Seleccion del checkbox = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //Detectar el evento de seleccion de radio button a traves del radio group
        rgGenere.setOnCheckedChangeListener { group, checkedId ->
            val idGnere = when(checkedId){
                R.id.rbWoman -> "Mujer"
                R.id.rbMan -> "Hombre"
                else -> "Desconocido"
            }
            Toast.makeText(this, "Valor del checkbox = $idGnere", Toast.LENGTH_LONG).show()
        }

        //Lista de datos para el spinner
        var datosSpinner = arrayListOf("Colombia", "Chile", "Argentina", "México")

        //Adapter para inicializar para asignar la colección de datos al spinner
        ArrayAdapter(this, android.R.layout.simple_spinner_item, datosSpinner).also {
            //Método para asignar el diseño a toda la lista
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = it
        }

        //Implementación de interfaces anónimas
        spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = datosSpinner[position]
                Toast.makeText(this@ComponentSelectionActivity, "Valor seleccionado = $itemSelected", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@ComponentSelectionActivity, "Nada seleccionado", Toast.LENGTH_LONG).show()
            }

        }

        //Detectar el estado del Checkbox al clickear el boton mostrar
        btnMostrar.setOnClickListener {
            val cbStatus = cbEstudiando.isChecked
            val rbSelected = when(rgGenere.checkedRadioButtonId){
                R.id.rbWoman -> "M"
                R.id.rbMan -> "H"
                else -> "D"
            }
            //Obtener el objeto seleccionado con el spinner
            val itemSelected = spinner.selectedItem
            Toast.makeText(this, "Valor de checkBox = $cbStatus El valor del radioButton = $rbSelected y el valor seleccionado del Spinner es = $itemSelected", Toast.LENGTH_LONG).show()
        }
    }
}