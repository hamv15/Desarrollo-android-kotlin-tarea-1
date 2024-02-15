package com.hamv.modulo4.componentesgraficos.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamv.modulo4.R

class UserAdapter(private val listaItems: ArrayList<User>) : RecyclerView.Adapter<UserViewHolder>() {

    //Para poder detectar la selecciòn del item
    var onItemSelected : ((User) -> Unit)? = null

    //Construcción o creación del xml (Se infla el componente"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = listaItems.size

    //Hace la unión entre los datos y el view consumiendo el render del View Holder
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(listaItems[position], onItemSelected)
    }


}

