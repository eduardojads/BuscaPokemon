package com.example.buscapokemon.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscapokemon.data.PokemonRepository
import com.example.buscapokemon.data.api.RetrofitClient
import com.example.buscapokemon.domain.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val repository = PokemonRepository(RetrofitClient.pokemonApi)

    //programação reativa
    val pokemonResponse = MutableLiveData<Pokemon>()

    fun getPokemon(id: Int) {
        viewModelScope.launch {
            val pokemon = repository.getPokemonData(id)
            pokemonResponse.value = pokemon
        }
    }
}