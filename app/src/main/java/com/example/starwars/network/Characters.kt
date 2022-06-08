package com.example.starwars.network

data class Characters (
    val results: List<Result>
) {
    data class Result(
        val name:String,
        val hair_color:String,
        val gender:String,
        val birth_year:String,
        val eye_color: String,
        val mass:String
    )
}