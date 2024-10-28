package com.uax.inicial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.uax.inicial.databinding.ActivityMainBinding

// Esto es la parte logica de una pantalla -> Activity (es una pantalla)

class MainActivity : AppCompatActivity() {
    // Primer metodo del ciclo de vida

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // junta, asocia parte grafica y parte logica (this)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        //a partir de aqui lo grafico y lo logico estan juntos

        binding.bottonPulsar.setOnClickListener {

            //lo que pasa cuando se pulsa el boton: sacar una notificacion
            Snackbar.make(
                binding.root,
                "Enhorabuena, completada la primera app",Snackbar.LENGTH_SHORT)
                .show()
        }

    }
}