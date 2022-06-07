package com.example.starwars.network

data class Films(
    val results: List<Result>
) {
    data class Result(
        val title:String,
        val opening_crawl:String
    )
}
