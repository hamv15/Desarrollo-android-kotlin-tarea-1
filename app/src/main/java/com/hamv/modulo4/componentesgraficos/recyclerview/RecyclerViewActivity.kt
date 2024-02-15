package com.hamv.modulo4.componentesgraficos.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamv.modulo4.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        //Crear referencia del recycler view
        val userList = findViewById<RecyclerView>(R.id.userList)

        //Creaciòn de lista a mostrar en el recyvler view
        val userDataList = arrayListOf(
            User("Hugo", "Hola123", "hamv15@hotmail.com"),
            User("Adrian", "Hola123", "osoNegro123@gmail.com"),
            User("Juan", "Hola123", "jphrndz@hotmail.com"),
            User("Felipe", "Hola123", "felipe@gmail.com"),
            User("Laura", "Hola123", "laura@hotmail.com"),
            User("Alejandra", "Hola123", "ale@yahoo.com"),
            User("Gerardo", "Hola123", "gerardo@live.com"),
            User("Diana", "Hola123", "diana@gmail.com"),
        )

        val adapter = UserAdapter(userDataList)

        adapter.onItemSelected = {
            Toast.makeText(this, "User selected = ${it.name}", Toast.LENGTH_LONG).show()
        }

        userList.adapter = adapter

        //LayOut manager nos va a decir como va a mostrar los elementos
        userList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}