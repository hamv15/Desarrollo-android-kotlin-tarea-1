package com.hamv.modulo4.tarea.entity

import java.io.Serializable

data class Usuario(
    var nombre: String,
    var primerApellido: String,
    var segundoApellido: String? =null,
    var genero: Int,
    var email: String,
    var password: String
): Serializable
