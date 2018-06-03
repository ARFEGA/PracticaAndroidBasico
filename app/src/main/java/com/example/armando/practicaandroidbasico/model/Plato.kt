package com.example.armando.practicaandroidbasico.model

import java.io.Serializable
import java.util.*

data class Plato(
        var id:String = UUID.randomUUID().toString(),
        var nombre:String,
        var descripcion:String,
        var alergenosImg:String,
        var precio:Int ,
        var img:String,
        var observaciones:String=""):Serializable{

}