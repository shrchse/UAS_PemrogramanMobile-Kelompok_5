package com.example.starwars.network

//starship
data class Starships(
    val results: List<Starships>
) {
    data class Starships(
        val name: String,
        val model: String
    )
}
