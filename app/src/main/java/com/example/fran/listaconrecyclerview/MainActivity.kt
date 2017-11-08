package com.example.fran.listaconrecyclerview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fila.view.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = lista as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListaAdapter(items, this)
    }

    class ListaAdapter(items: Array<String>, ctx: Context) : RecyclerView.Adapter<ListaAdapter.ViewHolder>() {

        var list = items
        var context = ctx

        //Numero elementos que habra en el RecyclerView
        override fun getItemCount(): Int {
            return list.size
        }

        //Se encarga del enlace de los datos en funcion de la posicion que ocupan
        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.name?.text = list.get(position)
            holder?.tamaño?.text = "Tamaño: " + list.get(position).length

            if(list.get(position).length > 4){
                holder?.icono!!.setImageResource(android.R.drawable.btn_star_big_off)
            }
            else{
                holder?.icono!!.setImageResource(android.R.drawable.btn_star_big_on)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.fila, parent, false))
        }

        class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
            var name = v.etiqueta
            var tamaño = v.tamanyo
            var icono = v.icono
        }
    }

    val items = arrayOf("En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre",
            "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía", "un",
            "hidalgo", "de", "los", "de", "lanza", "en", "astillero", "adarga", "antigua", "rocín",
            "flaco", "y", "galgo", "corredor"
    )
}
