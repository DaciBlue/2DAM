T2 - Inicializacion android

carpeta manifest -> AndroidManifest.xml

<!--Aqui podemos agregar permisos: internet, camara, localizacion, contactos, llamadas-->

- Parte LOGICA -> como se maneja la pantalla, "¿qué pasa sí?" ej.: que pasa si pulso un boton
  carpeta kotlin+java -> MainActivity
  <!--Esto es la parte logica de una pantalla -> Activity (es una pantalla)-->

  Toda pantalla de forma obligatoria tiene que tener una parte GRAFICA
  Los nombres de cada pantalla han de ser logicos.. MainActivity> pantalla principal, SecondActivity > pantalla secundaria etc..

- Parte GRAFICA - como se ve la pantalla
  carpeta res (viene de resources)
  dentro estan las carpetas:
  -layout: la parte GRAFICA de cada pantalla, aqui el nombre tiene que ser correlativo a la parte LOGICA
  Parte Logica: MainActivity ----> Parte Grafica: activity_main
  hay dos tipos de vistas: Design (pinchar y arrastrar cosas)
  Split (vista partida, aqui tocamos el codigo y se ve lo que modificamos con el codigo)
  en esta vista se ven sus dos modos a la vez: vista diseño y vista blueprint (limites de diseño: ej.: hasta donde llegan los margenes de los botones)
  -drawable(imagenes),
  -mipmap(imagenes vectoriales: que cambian de tamaño)
  aqui el movil por su propia cuenta captura la imagen que necesita ya sea: hdpi,mdpi,xxhdpi,xxxhdpi..
  -values: colores (para que apunten tus cosas a ese color)
  strings (todas las palabras: por ejemplo Pulsar. Lo creamos aqui y lo solicitamos desde donde lo necesitamos, evitamos cambiarlo en todas las pantallas que lo use)
  A esto se le llama INTERNACIONALIZAR: meter las palabras aqui para que sea mas facil todo
  -themes: los temas de la aplicacion

Concepto de Binding:
permite asociar la parte grafica, la parte logica de una forma diferente, tenerlo en una variable de tipo binding todos los elementos que estan dentro de la misma

    Para activar binding:

        en Gradle Scripts > build.gradle.kts(Module :app)
                en el nodo de android ponemos
                    viewBinding{
                        enable= true;
                    }
                    esto sirve para indicar que activamos la caracteristica de binding

        en MainActivity > vamos a meter la caracteristica del binding
         para eso creamos una variable: "private lateinit var binding: ActivityMainBinding"
            private lateinit(que la inciamos mas tarde)
            var(no es un valor fijo)
            binding: ActivityMainBinding (hacemos un enlace con el archivo de la carpeta layout: activiy_main, lo bindeamos a eso, porque se llaman igual)

         la inicializamos antes de lo grafico y logico (antes de setContentView)
            binding = ActivityMainBinding.inflate(layoutInflater)
                >> ActivityMainBinding - es el tipo que tiene marcado en la declaracion anterior private lateinit...
                >> .inflate - este metodo hace que el fichero que tiene el mismo nombre que tu lo activa (en este caso ActivityMainBinding tiene el mismo nombre que activty_main de la carpeta res/layout). Hara que este fichero ya no sea un fichero y ya esta, se va convertir en un layout funcional (la parte grafica funcional)
                >> layoutInflater - variable que existe por ser pantalla, llenamos el layout de "aire, espacio" para poder trabajar con el.

         tras inicializar lo ponemos dentro de setContentView apuntando al nodo superior, al nodo general:
            y quedara como setContentView(binding.root)

            ahora ya se puede trabajar con la parte grafica.

Conceptos de la parte grafica (res/layout/activity_main.xml)
<LinearLayout>

<!--Todos los elementos que esten dentro del linear se situan de forma linear: izq a derecha o de arriba a abajo-->

    <TextView> un texto
    <Button> un botton

    Para tamaño usamos SP android:textSize="30sp"

    android:layout_gravity="center" si tiene espacio disponible que se vaya al centro, esto se diferencia al probar con wrap content o match parent

    android:gravity="center" lo justificamos al centro, lo que hay dentro va al centro

    android:layout_marginTop="20dp" para separar un poco el boton de lo que tiene encima

    Si queremos interactuar con algo, que pasen cosas por ejemplo al pulsar un boton debemos de:
        darle un id: android:id="@+id/bottonPulsar" siempre @+id/
        en la parte logica: despues de de setContentView(binding.root)

        binding.bottonPulsar.setOnClickListener {

            //lo que pasa cuando se pulsa el boton: sacar una notificacion
            Snackbar.make(
                binding.root,
                "Enhorabuena, completada la primera app",Snackbar.LENGTH_SHORT)
                .show()
        }




    <!-- wrap content: ocupa unicamente lo que necesita el texto-->
    <!-- match parent: ocupa todo el espacio disponible-->
