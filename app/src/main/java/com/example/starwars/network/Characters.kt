package com.example.starwars.network

data class Characters (
    val results: List<Result>
) {
    data class Result(
        val name:String,
        val hair_color:String
    )
}