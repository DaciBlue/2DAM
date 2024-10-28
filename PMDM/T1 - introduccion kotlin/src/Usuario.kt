open class Usuario(var nombre: String, var apellido: String) {

    // la clase si no se marca como open, no se puede usar como herencia

    //varialbes

    var telefono: Int? = null

    //constructores -> 2 tipos > primarios(1) y secundarios (n)
        // constructor primario: aquel que me permite definir cuales son las variables obligatorias
        //                      para que esta clase exista. Ej.: un objeto que deberia de tener si o si nombre y apellido
        // constructor secundario: se basan en los primarios.
        //                      Ej. ademas del primario nombre y apellido, tendra secundario telefono, etc.

    constructor(nombre: String, apellido: String, telefono: Int):this(nombre,apellido){
        this.telefono= telefono

        // primero creamos constructor secundario y le decimos los parametros que queremos
        // al ser secundario debemos coger los constructores primarios y añadimos el extra, en este caso telefono
        // al final de los constructores le ponemos los construcotres primarios en los que nos hemos basado :this(nombre,apellido)
    }



    //funciones

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Telefono: ${telefono?: "no hay telefono"}")
    }
}