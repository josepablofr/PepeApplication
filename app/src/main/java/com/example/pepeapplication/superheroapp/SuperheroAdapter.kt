package com.example.pepeapplication.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pepeapplication.R

class SuperheroAdapter(var superheroList:List<SuperheroItemResponse> = emptyList()) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroList: List<SuperheroItemResponse>){
        this.superheroList = superheroList  // cuando pongo "this" me refiero al de la clase y sin "this" al del listado
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
       viewholder.bind(superheroList[position])
    }

    override fun getItemCount() = superheroList.size
}