package com.hamv.modulo4.componentesgraficos.recyclerview

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.hamv.modulo4.R

class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
    //Obtención de referncias de objetos en la vista
    val ivUser = view.findViewById<ImageView>(R.id.ivUser)
    val tvUser = view.findViewById<TextView>(R.id.tvUser)

    //Referencias para agregarles el listener
    val root = view.findViewById<ConstraintLayout>(R.id.root)
    val card = view.findViewById<CardView>(R.id.card)

    fun render(user:User, onItemSelected : ((User)->Unit)?){
        //Seteo de valores del objeto en la lista al elemento visual
        tvUser.text=user.mail
        tvUser.typeface = ResourcesCompat.getFont(tvUser.context, R.font.bernier_shade_regular)

        //Función lamda para invocar item seleccionado **importante: tu decides a que componente de tu vista le agregas el escuchador de eventos
        root.setOnClickListener{
            onItemSelected?.invoke(user)
        }
    }
}