package com.example.armando.practicaandroidbasico.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import com.example.armando.practicaandroidbasico.R
import com.example.armando.practicaandroidbasico.adapter.PedidosMesaAdapter
import com.example.armando.practicaandroidbasico.model.*

import kotlinx.android.synthetic.main.activity_mesa.*


class MesaActivity : AppCompatActivity() {



    companion object {
        val REQUEST_PLATO = 1
        val EXTRA_MESA = "EXTRA_MESA"
        var adapter : PedidosMesaAdapter? = null

        fun newIntent(context : Context, mesa:Int):Intent{
            val intent = Intent(context , MesaActivity::class.java)
            intent.putExtra(EXTRA_MESA,mesa)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesa)
        val selectedMesa = intent.getIntExtra(EXTRA_MESA,0) - 1
        val mesa = Mesas.getMesa(selectedMesa)
        mesa.pedidos.add(Pedido(comensal=1, plato = Platos.getPlato(1)))
        mesa.pedidos.add(Pedido(comensal=1, plato = Platos.getPlato(2)))
        mesa.pedidos.add(Pedido(comensal=1, plato = Platos.getPlato(3)))
        mesa.pedidos.add(Pedido(comensal=1, plato = Platos.getPlato(4)))
        updateMesaInfo(mesa)

        //Creación de lista de mesas
        val list: RecyclerView = pedidos_mesa_list_recycler
        list.layoutManager = LinearLayoutManager(this)
        adapter = PedidosMesaAdapter(mesa)
        adapter?.onPlatoClickListener = View.OnClickListener {
            //Alguien ha pulsado en un elemento del RecyclerView.
            //Nos valdremos de "it"
            //Obtenemos la fila pulsada (la mesa)
            //Para eliminar plato pedido
            val platoPulsado = list.getChildAdapterPosition(it) + 1
            //TODO:eliminar plato pedido

        }
        list.adapter = adapter

        add_button.setOnClickListener {
            //Llamo a la actividad platos
            startActivityForResult(PlatosActivity.newIntent(this,mesa),REQUEST_PLATO)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_PLATO ->{
                if (resultCode == Activity.RESULT_OK && data != null){
                    val mesa = data.getSerializableExtra("EXTRA_MESA") as? Mesa
                    val indexPlato = data.getIntExtra("EXTRA_PLATO",0)
                    val plato = Platos.getPlato(indexPlato)
                    plato.observaciones = data.getStringExtra("EXTRA_OBSERVACIONES")
                    adapter?.setPlatos(plato)
                }

            }
        }
    }
    //Para incluir información en ActionBar
    private fun updateMesaInfo(mesa:Mesa) {
        if(this is AppCompatActivity) {
            val supportActionBar = (this as? AppCompatActivity)?.supportActionBar
            supportActionBar?.title = "MESA: ${mesa.numero} (${mesa.comensales} comensales)"
        }
    }


}