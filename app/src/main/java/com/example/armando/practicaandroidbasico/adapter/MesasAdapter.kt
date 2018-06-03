package com.example.armando.practicaandroidbasico.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.armando.practicaandroidbasico.R
import com.example.armando.practicaandroidbasico.model.Mesa

class MesasAdapter:RecyclerView.Adapter<MesasAdapter.MesaViewHolder>() {

    private val mesas = mutableListOf<Mesa>()

    //private val mesaClickListener : ((Mesa,Int)-> Unit)
    var onMesaClickListener:View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MesaViewHolder {
       val row = LayoutInflater.from(parent.context)
               .inflate(R.layout.item_mesa,parent,false)

        row.setOnClickListener(onMesaClickListener)
        return  MesaViewHolder(row)
    }

    override fun getItemCount(): Int {
        return mesas.size
    }

    override fun onBindViewHolder(holder: MesaViewHolder, position: Int) {
        val mesa = mesas[position]
        //La mesa de MesaViewHolder es la mesa aquí creada
        holder.mesa = mesa

    }
    fun setMesas(mesasAux:MutableList<Mesa>){
        mesas.clear()
        mesas.addAll(mesasAux)

        notifyDataSetChanged()

    }
    inner class MesaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var mesa: Mesa? = null
        set(value) {
            value?.let {
                itemView.findViewById<TextView>(R.id.label_mesa).text = "Mesa ${value.numero}"
            }
            field = value
        }


    }
}