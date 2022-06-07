package com.example.starwars.ui.starships

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.Card2Binding
import com.example.starwars.network.Starships

class StarshipsAdapter(private val clickListener: StarshipsListener) :
    ListAdapter<Starships.Data, StarshipsAdapter.StarshipsViewHolder>(DiffCallback){
    class StarshipsViewHolder(var binding: Card2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: StarshipsListener, data: Starships.Data ) {
            binding.starship= data
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

    companion object DiffCallback : DiffUtil.ItemCallback<Starships.Data>() {
        override fun areItemsTheSame(oldItem: Starships.Data, newItem: Starships.Data): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Starships.Data, newItem: Starships.Data): Boolean {
            return oldItem.name == newItem.name
        }
    }
}

class StarshipsListener(val clickListener: (starships: Starships.Data) -> Unit) {
    fun onClick(starships: Starships.Data) = clickListener(starships)
}