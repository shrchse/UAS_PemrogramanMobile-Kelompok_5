package com.example.starwars

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.network.Characters
import com.example.starwars.network.StarWarsApiService
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

    // todo

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
}