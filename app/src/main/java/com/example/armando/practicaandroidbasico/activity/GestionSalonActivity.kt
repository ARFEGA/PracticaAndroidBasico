package com.example.armando.practicaandroidbasico.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.view.View
import android.widget.Button
import com.example.armando.practicaandroidbasico.R
import com.example.armando.practicaandroidbasico.adapter.MesasAdapter

import com.example.armando.practicaandroidbasico.model.Mesas
import kotlinx.android.synthetic.main.activity_gestion_salon.*

class GestionSalonActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_salon)

        val mesas = Mesas.mesas
        //Creación de lista de mesas
        val list: RecyclerView = list_recycler
        list.layoutManager = LinearLayoutManager(this)
        val adapter = MesasAdapter()

        adapter.setMesas(mesas)
        adapter?.onMesaClickListener = View.OnClickListener {
            //Alguien ha pulsado en un elemento del RecyclerView.
            //Nos valdremos de "it"
            //Obtenemos la fila pulsada (la mesa)
            val mesaPulsada = list.getChildAdapterPosition(it) + 1
            startActivity(MesaActivity.newIntent(this, mesaPulsada))
        }
        list.adapter = adapter



        val btnMesa :Button = findViewById(R.id.button_mesa)
        btnMesa.setOnClickListener {
            startActivity(MesaActivity.newIntent(this, 1)) }

    }
}