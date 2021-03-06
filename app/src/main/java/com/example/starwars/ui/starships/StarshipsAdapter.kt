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
        fun bind(clickListener: StarshipsListener, starships: Starships.Data ) {
            binding.starship = starships
            binding.starshipClickListener = clickListener
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
        val starships = getItem(position)
        holder.bind(clickListener, starships)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Starships.Data>() {
        override fun areItemsTheSame(oldItem: Starships.Data, newItem: Starships.Data): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Starships.Data, newItem: Starships.Data): Boolean {
            return oldItem.starship_class == newItem.starship_class
        }
    }
}

class StarshipsListener(val clickListener: (starships: Starships.Data) -> Unit) {
    fun onClick(starships: Starships.Data) = clickListener(starships)
}