package com.example.armando.practicaandroidbasico.model

import java.io.Serializable
import java.util.*

data class Pedido(
        var id:String = UUID.randomUUID().toString(),
        var comensal:Int,
        var plato: Plato):Serializable{

}