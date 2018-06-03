package com.example.armando.practicaandroidbasico.model

object Mesas {
    var mesas : MutableList<Mesa> = mutableListOf()
    get(){
        if (field.isEmpty())
            field = dummyMesas()
        return field
    }

    private fun dummyMesas():MutableList<Mesa>{
        return (1..10).map {index ->
            Mesa(
                    numero = index,
                    comensales = 4,
                    ocupada = false,
                    pedidos = mutableListOf()
            )
        }.toMutableList()
    }

    fun getMesa(numero:Int) = mesas[numero]
    val count get() = mesas.size
    //fun ToArray() = mesas.toTypedArray()
}