package com.hamv.modulo4.ejercicio2.recyclerautos

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.hamv.modulo4.R
import com.hamv.modulo4.componentesgraficos.recyclerview.User

class AutoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    //Obtención de referncias de objetos en la vista
    val ivAuto = view.findViewById<ImageView>(R.id.ivAuto)
    val tvAuto = view.findViewById<TextView>(R.id.tvAuto)

    //Referencias para agregarles el listener
    val rootAuto = view.findViewById<ConstraintLayout>(R.id.rootAuto)
    val cardAuto = view.findViewById<CardView>(R.id.cardAuto)

    fun render(auto: Auto, onItemSelected : ((Auto)->Unit)?){
        //Seteo de valores del objeto en la lista al elemento visual
        tvAuto.text=auto.marca+" "+auto.modelo
        tvAuto.typeface = ResourcesCompat.getFont(tvAuto.context, R.font.bernier_shade_regular)

        //Función lamda para invocar item seleccionado **importante: tu decides a que componente de tu vista le agregas el escuchador de eventos
        rootAuto.setOnClickListener{
            onItemSelected?.invoke(auto)
        }
    }

}