package com.example.starwars.network

data class Starships(
    val results: List<Data>
) {
    data class Data(
        val name: String,
        val model: String
    )
}
