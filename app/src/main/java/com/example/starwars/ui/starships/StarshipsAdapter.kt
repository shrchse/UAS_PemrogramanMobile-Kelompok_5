package com.example.starwars.ui.starships

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.Card2Binding
import com.example.starwars.network.Starships
import com.example.starwars.ui.characters.CharacterAdapter
import com.example.starwars.ui.starships.StarshipsAdapter

class StarshipsAdapter(private val clickListener: StarshipsListener) :
    ListAdapter<Starships.Starships, StarshipsAdapter.StarshipsViewHolder>(DiffCallback){
    class StarshipsViewHolder(var binding: Card2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: StarshipsListener, starships: Starships.Starships ) {
            binding.starship= starships
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StarshipsViewHolder(
            Card2Binding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StarshipsViewHolder, position: Int) {
        val characters = getItem(position)
        holder.bind(clickListener, characters)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Starships.Starships>() {
        override fun areItemsTheSame(oldItem: Starships.Starships, newItem: Starships.Starships): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Starships.Starships, newItem: Starships.Starships): Boolean {
            return oldItem.name == newItem.name
        }
    }
}

class StarshipsListener(val clickListener: (characters: Starships.Starships) -> Unit) {
    fun onClick(characters: Starships.Starships) = clickListener(characters)
}