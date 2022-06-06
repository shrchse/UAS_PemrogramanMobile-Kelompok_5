package com.example.starwars

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.network.Characters
import com.example.starwars.ui.characters.CharacterAdapter

@BindingAdapter("listData")
fun bindRecyclerViewCharacter(recyclerView: RecyclerView, data: List<Characters.Result>?){
    val adapter = recyclerView.adapter as CharacterAdapter
    adapter.submitList(data)
}