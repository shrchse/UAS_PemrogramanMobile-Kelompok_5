package com.example.starwars

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.network.Characters
import com.example.starwars.network.StarWarsApiService
import com.example.starwars.network.Starships
import kotlinx.coroutines.launch
import java.lang.Exception

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
    fun onStarshipClicked(data: Starships.Data){
        _soloStarships.value = data
    }
}
