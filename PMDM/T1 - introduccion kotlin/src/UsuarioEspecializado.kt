// En JAVA: para las herencias > extends, para interfaz > implements

class UsuarioEspecializado(nombre: String, apellido: String, telefono: Int, var correo: String) :Usuario(nombre,apellido,telefono){

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Correo: $correo")
    }
}