package com.example.armando.practicaandroidbasico.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.armando.practicaandroidbasico.R
import com.example.armando.practicaandroidbasico.model.Mesa
import com.example.armando.practicaandroidbasico.model.Pedido
import com.example.armando.practicaandroidbasico.model.Plato

class PedidosMesaAdapter(private val mesa:Mesa):
        RecyclerView.Adapter<PedidosMesaAdapter.PlatoViewHolder>() {

    var onPlatoClickListener:View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatoViewHolder {
       val row = LayoutInflater.from(parent.context)
               .inflate(R.layout.item_plato_pedido,parent,false)

        row.setOnClickListener(onPlatoClickListener)
        return  PlatoViewHolder(row)
    }

    override fun getItemCount(): Int {
        return mesa.pedidos.size
    }

    override fun onBindViewHolder(holder: PlatoViewHolder, position: Int) {
        val plato = mesa.pedidos[position].plato
        //La mesa de MesaViewHolder es la mesa aquí creada
        holder.plato = plato

    }
    fun setPlatos(plato:Plato){
        mesa.pedidos.add(Pedido(comensal=1,plato = plato))
        notifyDataSetChanged()

    }
    inner class PlatoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var plato: Plato? = null
        set(value) {
            value?.let {
                itemView.findViewById<TextView>(R.id.nombre_plato_pedido).text = value.nombre
                itemView.findViewById<TextView>(R.id.observaciones).text = value.observaciones
            }
            field = value
        }


    }
}