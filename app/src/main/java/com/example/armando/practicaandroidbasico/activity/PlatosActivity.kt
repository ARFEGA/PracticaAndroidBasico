package com.example.armando.practicaandroidbasico.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.armando.practicaandroidbasico.R

import com.example.armando.practicaandroidbasico.adapter.PlatosAdapter
import com.example.armando.practicaandroidbasico.model.Mesa
import com.example.armando.practicaandroidbasico.model.Platos.getPlatos
import kotlinx.android.synthetic.main.activity_platos.*

class PlatosActivity : AppCompatActivity() {

    companion object {
        val EXTRA_MESA = "EXTRA_MESA"
        val EXTRA_PLATO = "EXTRA_PLATO"
        val EXTRA_OBSERVACIONES = "EXTRA_OBSERVACIONES"
        fun newIntent(context : Context, mesa: Mesa): Intent {
            val intent = Intent(context , PlatosActivity::class.java)
            intent.putExtra(EXTRA_MESA,mesa)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platos)

        val platos = getPlatos()
        //Creación de lista de platos
        val list: RecyclerView = platos_list_recycler
        list.layoutManager = LinearLayoutManager(this)
        val adapter = PlatosAdapter(platos)

        //adapter.setMesas(mesas)
        adapter?.onPlatoClickListener = View.OnClickListener {
            //Alguien ha pulsado en un elemento del RecyclerView.
            //Nos valdremos de "it"
            //Obtenemos la fila pulsada (el plato)
            val platoPulsado = list.getChildAdapterPosition(it)

            //Inflamos la vista para que aparezca en el alert
            val customView = layoutInflater.inflate(R.layout.view_platoinput,null)
//            // Hacemos referencia al textbox
            val edit = customView.findViewById<EditText?>(R.id.plato_name)
            AlertDialog.Builder(this)
                    .setTitle("Orservaciones al plato")
                    .setMessage("Introduce información adicional para cocina")
                    .setView(customView)
                    .setPositiveButton(android.R.string.ok,{
                        _,_ -> //Añadimos observación
//                       // Snackbar.make(findViewById(android.R.id.content),edit?.text.toString(), Snackbar.LENGTH_LONG)
                            //.show()
                        Log.i("EEEEEEE",edit?.text.toString())
                        val returnIntent = Intent()
                        returnIntent.putExtra(EXTRA_PLATO,platoPulsado)
                        returnIntent.putExtra(EXTRA_MESA,intent.getSerializableExtra(EXTRA_MESA))
                        returnIntent.putExtra(EXTRA_OBSERVACIONES,edit?.text.toString())
                        setResult(Activity.RESULT_OK,returnIntent)
                        finish()


                    })
                    .setNegativeButton(android.R.string.cancel,null)
                    .show()


        }
        list.adapter = adapter
    }
}
