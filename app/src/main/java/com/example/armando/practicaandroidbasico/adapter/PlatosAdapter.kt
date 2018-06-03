package com.example.armando.practicaandroidbasico.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.armando.practicaandroidbasico.R
import com.example.armando.practicaandroidbasico.model.Plato

class PlatosAdapter(private val platos:List<Plato>):RecyclerView.Adapter<PlatosAdapter.PlatoViewHolder>() {



    //private val mesaClickListener : ((Mesa,Int)-> Unit)
    var onPlatoClickListener:View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatoViewHolder {
       val row = LayoutInflater.from(parent.context)
               .inflate(R.layout.item_plato,parent,false)

        row.setOnClickListener(onPlatoClickListener)
        return  PlatoViewHolder(row)
    }

    override fun getItemCount(): Int {
        return platos.size
    }

    override fun onBindViewHolder(holder: PlatoViewHolder, position: Int) {
        val plato = platos[position]
        //La mesa de MesaViewHolder es la mesa aquí creada
        holder.plato = plato

    }
    fun setPlatos(platosAux:MutableList<Plato>){

        notifyDataSetChanged()

    }
    inner class PlatoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var plato: Plato? = null
        set(value) {
            value?.let {
                itemView.findViewById<TextView>(R.id.nombre_plato).text = value.nombre
                itemView.findViewById<TextView>(R.id.text_precio).text = value.precio.toString()
                itemView.findViewById<TextView>(R.id.descripcion_plato).text = value.descripcion
                //itemView.findViewById<TextView>(R.id.text_alergenos).text = value.alergenosImg
            }
            field = value
        }


    }
}