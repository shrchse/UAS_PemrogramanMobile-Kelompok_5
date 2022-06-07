package com.example.starwars

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.network.Characters
import com.example.starwars.network.Films
import com.example.starwars.network.StarWarsApiService
import com.example.starwars.network.Starships
import kotlinx.coroutines.launch
import kotlin.Exception

enum class ApiStatus {LOADING, ERROR, DONE}

class StarwarsViewModel:ViewModel(){
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    //Api People - Character
    private val _characters = MutableLiveData<Characters>()
    val characters:LiveData<Characters> = _characters
    private val _soloCharacter = MutableLiveData<Characters.Result>()
    val soloCharacter:LiveData<Characters.Result> = _soloCharacter

    //Api Starships - ShipStar
    private val _starships = MutableLiveData<Starships>()
    val starships:LiveData<Starships> = _starships
    private val _soloStarships = MutableLiveData<Starships.Data>()
    val soloStarships:LiveData<Starships.Data> = _soloStarships

    //Api Film
    private val _film = MutableLiveData<Films>()
    val film:LiveData<Films> = _film
    private val _soloFilm = MutableLiveData<Films.Result>()
    val soloFilm:LiveData<Films.Result> = _soloFilm

    fun getCharacter() {
        viewModelScope.launch {
            try {
                _characters.value = StarWarsApiService.retrofitServiceApi.getCharacter()
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _characters.value = Characters(listOf())
            }
        }
    }
    fun onCharacterClicked(characters: Characters.Result){
        _soloCharacter.value = characters
    }
    fun getStarship(){
        viewModelScope.launch {
            try {
                _starships.value = StarWarsApiService.retrofitServiceApi.getStarship()
            } catch (e: Exception) {
                Log.d("error",e.printStackTrace().toString())
                _starships.value = Starships(listOf())
            }
        }
    }
    fun onStarshipClicked(starships: Starships.Data){
        _soloStarships.value = starships
    }
    fun getFilms(){
        viewModelScope.launch {
            try{
                _film.value = StarWarsApiService.retrofitServiceApi.getFilm()
            } catch (e:Exception){
                Log.d("error", e.printStackTrace().toString())
                _film.value = Films(listOf())
            }
        }
    }
    fun onFilmClicked(films: Films.Result){
        _soloFilm.value = films
    }
}
