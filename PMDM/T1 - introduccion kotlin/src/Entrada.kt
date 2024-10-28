// variables
// funciones
// void -> Unit
fun main (args: Array<String>){
    //sumar (2,4)
    // Variables en kotlin siempre Complejas
    // variables que pueden cambiar su valor -> mutable
        //var operandoUno: Int;
        //var operandoUno = "8";
        var operandoUno = 8;

    // variables que NO pueden cambiar su valor -> val
        val operandoDos: Int= 7; // es redundante no hace falta el int
       // operandoDos = 5; // no deja porque no es mutable es un val

    // Null Safety -> Seguridad de que no vas a tener errores de tipo null
    //                  poner ? despues de los tipos String, Int..
    //                  garantiza que puede haber una palabra o un null

    var nombre: String? = null;

    println(nombre?.length ?: "No hay nombre")
    // al poner ? -> si lo que esta detras de el es null, lo que esta delante no se ejecuta
    // al poner ?: -> si antes del primer ? es null, se ejecuta lo que hay despues de ?:

    // lateinit -> para una varible que sabes que en algun futuro la vamos a usar
    lateinit var apellido : String
    apellido = "ejemplo" // aqui la estamos inicializando
    println("Mi apellido es $apellido") // nos daria un error de no incializar si nu estuviera incializado pero no habria problema en ponerlo

    println("El resultado de la suma es ${sumar(4,6)}")
    // poniendo ?{sumar() cogemos la ejecucion de una funcion y le decimos sus variables, es codigo a ejecutar

    println(sumar(operandoDos= 5, operandoUno = 10))
    println(multiplicar(operandoUno= 4, operandoDos= 3))
    println(multiplicar(operandoDos= 3))
    println(multiplicar())
    println("El resultado de la funcion dividir es ${dividir(6,3)}")
    println("El resultado de la funcion duplicar es ${duplicar(6)}")
    var usuario = Usuario(nombre = "Dacian", apellido= "Radoi")
    var usuario1 = Usuario(nombre = "Dacian", apellido= "Radoi", telefono = 123)
    println(usuario.nombre)
    println(usuario1.telefono)
    usuario1.mostrarDatos()
    usuario.mostrarDatos()

}
fun sumar(operandoUno: Int, operandoDos: Int): Int{
    return operandoUno+operandoDos
}

fun multiplicar(operandoUno: Int = 1,operandoDos: Int= 10): Int{
    return operandoUno*operandoDos
}

// funciones lambda

val dividir = { operandoUno: Int, operandDos: Int -> operandoUno/operandDos}

val duplicar = { operando: Int -> operando*2}

// clase