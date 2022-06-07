package com.example.starwars.network

class Starships {
}

//starship
data class Starships(
    val results: List<Starships>
) {
    data class Starships(
        val name: String,
        val model: String
    )
}
