package com.example.starwars.ui.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.Card3Binding
import com.example.starwars.network.Films

class FilmAdapter(private val clickListener: FilmListener) :
    ListAdapter<Films.Result, FilmAdapter.FilmViewHolder>(DiffCallback){
    class FilmViewHolder(var binding: Card3Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: FilmListener, data: Films.Result ) {
            binding.film= data
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FilmViewHolder(
            Card3Binding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val films = getItem(position)
        holder.bind(clickListener, films)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Films.Result>() {
        override fun areItemsTheSame(oldItem: Films.Result, newItem: Films.Result): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Films.Result, newItem: Films.Result): Boolean {
            return oldItem.opening_crawl == newItem.opening_crawl
        }
    }
}

class FilmListener(val clickListener: (films: Films.Result) -> Unit) {
    fun onClick(films: Films.Result) = clickListener(films)
}