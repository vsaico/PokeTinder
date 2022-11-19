package com.saico.victor.poketinder.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saico.victor.poketinder.data.database.entities.MyPokemonEntity
import com.saico.victor.poketinder.databinding.ItemPokemonSavedBinding

class MyPokemonsHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonSavedBinding.bind(view)

    fun bind(pokemon: MyPokemonEntity) {
        with(binding) {
            binding.tvIndex.text = formatNumberTo3Digits(pokemon.idPokemon.toInt())
            tvName.text = pokemon.name
            tvType.text = if (pokemon.isLegendary) "legendary" else "Normal"
            Glide
                .with(itemView)
                .load(pokemon.image)
                .into(binding.ivPokemonLogo)
        }
    }

    fun formatNumberTo3Digits(number: Int): String = "#${"%03d".format(number)}"
}