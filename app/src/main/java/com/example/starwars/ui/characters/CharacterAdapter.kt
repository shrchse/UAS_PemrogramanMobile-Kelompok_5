package com.example.starwars.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.CardBinding
import com.example.starwars.network.Characters

class CharacterAdapter(private val clickListener: CharacterListener) :
    ListAdapter<Characters.Result, CharacterAdapter.CharacterViewHolder>(DiffCallback) {
    class CharacterViewHolder(var binding: CardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: CharacterListener, character: Characters.Result) {
            binding.character = character
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(
            CardBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val characters = getItem(position)
        holder.bind(clickListener, characters)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Characters.Result>() {
        override fun areItemsTheSame(oldItem: Characters.Result, newItem: Characters.Result): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Characters.Result, newItem: Characters.Result): Boolean {
            return oldItem.name == newItem.name
        }
    }
}

class CharacterListener(val clickListener: (characters: Characters.Result) -> Unit) {
    fun onClick(characters: Characters.Result) = clickListener(characters)
}