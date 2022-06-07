package com.example.starwars

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.network.Characters
import com.example.starwars.network.Films
import com.example.starwars.network.Starships
import com.example.starwars.ui.characters.CharacterAdapter
import com.example.starwars.ui.film.FilmAdapter
import com.example.starwars.ui.starships.StarshipsAdapter

@BindingAdapter("listData")
fun bindRecyclerViewCharacter(recyclerView: RecyclerView, data: List<Characters.Result>?){
    val adapter = recyclerView.adapter as CharacterAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataStarship")
fun bindRecyclerviewStarships(recyclerView: RecyclerView, data : List<Starships.Data>?){
    val adapter = recyclerView.adapter as StarshipsAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataFilm")
fun bindRecyclerviewFilm(recyclerView: RecyclerView, data : List<Films.Result>?){
    val adapter = recyclerView.adapter as FilmAdapter
    adapter.submitList(data)
}
