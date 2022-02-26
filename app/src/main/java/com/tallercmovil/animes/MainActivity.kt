package com.tallercmovil.animes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tallercmovil.animes.databinding.ActivityMainBinding
import com.tallercmovil.animes.model.Anime

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = ArrayList<Anime>()

        for(i in 1 until 50){
            val animeTmp = Anime(i.toLong(), "Título $i", "Tipo $i", "Fecha $i")
            datos.add(animeTmp)
        }

        with(binding) {
            lvAnimes.adapter = AnimeAdapter(this@MainActivity, datos)

            lvAnimes.setOnItemClickListener { adapterView, view, i, l ->
                //i es la posición
                //l es el id
                //Toast.makeText(this@MainActivity, "Se hizo click en el elemento con id: $l en la posición $i", Toast.LENGTH_LONG).show()

                //Para obtener info del item seleccionado (objeto Anime seleccionado)

                val animeSeleccionado = adapterView.adapter.getItem(i) as Anime

                Toast.makeText(this@MainActivity, "El título del anime seleccionado es: ${animeSeleccionado.titulo}", Toast.LENGTH_LONG).show()
            }

        }




    }
}