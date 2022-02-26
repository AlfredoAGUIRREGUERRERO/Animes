package com.tallercmovil.animes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.tallercmovil.animes.databinding.ElementoListaBinding
import com.tallercmovil.animes.model.Anime

class AnimeAdapter(private val contexto: Context, val datos: ArrayList<Anime>): BaseAdapter() {

    private val layoutInflater = LayoutInflater.from(contexto)

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(p0: Int): Any {
        //p0 es la posición
        return datos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return datos[p0].id
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ElementoListaBinding.inflate(layoutInflater)

        with(binding){
            tvTitulo.text = datos[position].titulo
            tvTipo.text = datos[position].tipo
            tvFecha.text = datos[position].fecha
        }

        return binding.root
    }
}