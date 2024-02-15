package com.hamv.modulo4.ejercicio2.recyclerautos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamv.modulo4.R

class AutoAdapter(private val listaItems: ArrayList<Auto>): RecyclerView.Adapter<AutoViewHolder>() {

    //Para poder detectar la selecciòn del item
    var onItemSelected : ((Auto) -> Unit)? = null

    //Construcción o creación del xml (Se infla el componente"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_auto, parent, false)
        return AutoViewHolder(view)
    }

    override fun getItemCount(): Int = listaItems.size

    //Hace la unión entre los datos y el view consumiendo el render del View Holder
    override fun onBindViewHolder(holder: AutoViewHolder, position: Int) {
        holder.render(listaItems[position], onItemSelected)
    }

}