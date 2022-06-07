package com.example.starwars.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://swapi.dev/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
//people
interface StarwarsServiceApi {
    @GET("people")
    suspend fun getCharacter(): Characters
    @GET("starships")
    suspend fun getStarship(): Starships
    @GET("films")
    suspend fun getFilm(): Films
}

object StarWarsApiService {
    val retrofitServiceApi: StarwarsServiceApi by lazy {
        retrofit.create(StarwarsServiceApi::class.java)
    }
}
