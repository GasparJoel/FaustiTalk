package com.faustino.faustitalk.View.Register_Profile

class User {
    private var username: String = ""
    private var nombre: String = ""
    private var apellido: String = ""
    private var email: String = ""
    private var fechaNac: String = ""
    private var genero: String = ""
    private var tipoPerfil: String = ""
    private var descripcion: String = ""

    constructor()

    fun setUsername(username: String) {
        if (username.isNotEmpty()) {
            this.username = username
        } else {
            println("El username no puede estar vacío.")
        }
    }

    fun getUsername(): String {
        return this.username
    }

    fun setNombre(nombre: String) {
        if (nombre.isNotEmpty()) {
            this.nombre = nombre
        } else {
            println("El nombre no puede estar vacío.")
        }
    }

    fun getNombre(): String {
        return this.nombre
    }

    fun setApellido(apellido: String) {
        if (apellido.isNotEmpty()) {
            this.apellido = apellido
        } else {
            println("El apellido no puede estar vacío.")
        }
    }

    fun getApellido(): String {
        return this.apellido
    }

    fun setEmail(email:String){
        if (email.isNotEmpty()) {
            this.email = email
        } else {
            println("El email no puede estar vacío.")
        }
    }

    fun getEmail(): String {
        return this.email
    }

    fun setFechaNac(fechaNac: String) {
        if (fechaNac.isNotEmpty()) {
            this.fechaNac = fechaNac
        } else {
            println("La fecha de nacimiento no puede estar vacía.")
        }
    }

    fun getFechaNac(): String {
        return this.fechaNac
    }

    fun setGenero(genero: String) {
        if (genero.isNotEmpty()) {
            this.genero = genero
        } else {
            println("El género no puede estar vacío.")
        }
    }

    fun getGenero(): String {
        return this.genero
    }

    fun setTipoPerfil(tipoPerfil: String) {
        if (tipoPerfil.isNotEmpty()){
            //in listOf("Estudiante", "Docente", "Administrativo")) {
            this.tipoPerfil = tipoPerfil
        } else {
            println("Tipo de perfil no válido.")
        }
    }

    fun getTipoPerfil(): String {
        return this.tipoPerfil
    }

    fun setDescripcion(descripcion: String) {
        this.descripcion = descripcion
    }

    fun getDescripcion(): String {
        return this.descripcion
    }

}
