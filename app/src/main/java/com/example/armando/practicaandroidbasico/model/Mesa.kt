package com.example.armando.practicaandroidbasico.model

import java.io.Serializable
import java.util.*

data class Mesa(
        var id:String = UUID.randomUUID().toString(),
        var numero:Int,
        var comensales:Int,
        var ocupada:Boolean,
        var pedidos:MutableList<Pedido> ):Serializable{

}