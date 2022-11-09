package com.saico.victor.poketinder.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saico.victor.poketinder.R
import com.saico.victor.poketinder.data.model.PokemonResponse
import com.saico.victor.poketinder.databinding.ItemPokemonBinding

class PokemonAdapter(
    var list: List<PokemonResponse>,
    val callback: Callback
): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_pokemon)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPokemon = list[position]
        holder.bind(itemPokemon)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemPokemonBinding.bind(view)

        fun bind(pokemon: PokemonResponse) {
            with(binding) {
                root.setOnClickListener {
                    callback.onClickPokemonInformation(pokemon)
                }
                tvName.text = pokemon.name
                Glide
                    .with(itemView)
                    .load(pokemon.getPokemonImage())
                    .into(ivPokemon)
            }
        }
    }

    interface Callback {
        fun onClickPokemonInformation(pokemon: PokemonResponse)
    }
}

fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

