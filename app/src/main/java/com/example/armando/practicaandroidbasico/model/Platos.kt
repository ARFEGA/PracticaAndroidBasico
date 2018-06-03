package com.example.armando.practicaandroidbasico.model

object Platos {
    private val platos : List<Plato> = listOf(
            Plato(nombre = "Fabada", descripcion = "Alubias blancas", alergenosImg = "x.x", precio = 3, img = "y.y"),
            Plato(nombre = "Sopa Cocido", descripcion = "Sopa de fideos", alergenosImg = "x.png", precio = 3, img = "y.png"),
            Plato(nombre = "Cocido", descripcion = "Cocido madrileño, tres vuelcos", alergenosImg = "x.x", precio = 3, img = "y.y"),
            Plato(nombre = "Pollo asado", descripcion = "Pollo al horno en su salsa", alergenosImg = "x.x", precio = 3, img = "y.y"),
            Plato(nombre = "Paella", descripcion = "Paella con verdura", alergenosImg = "x.x", precio = 3, img = "y.y"),
            Plato(nombre = "Arroz negro", descripcion = "Arron con tinta de calamar", alergenosImg = "x.x", precio = 3, img = "y.y"),
            Plato(nombre = "Callos", descripcion = "Callos de vaca", alergenosImg = "x.x", precio = 3, img = "y.y"),
            Plato(nombre = "Solomillo", descripcion = "Solomillo de ternera roja", alergenosImg = "x.x", precio = 3, img = "y.y")
    )

    fun getPlato(numero:Int) = platos[numero]
    val count get() = platos.size
    fun ToArray() = platos.toTypedArray()
    fun getPlatos() = platos
}



