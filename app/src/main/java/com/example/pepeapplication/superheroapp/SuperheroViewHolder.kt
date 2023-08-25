package com.example.pepeapplication.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pepeapplication.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = superheroItemResponse.name
        Picasso.get().load(superheroItemResponse.superheroImage.url)
            .into(binding.ivSuperhero)  // Esta llamada se aprende de la página de documentación de la librería de Picasso
        binding.root.setOnClickListener { onItemSelected(superheroItemResponse.superheroId) }
    }
}