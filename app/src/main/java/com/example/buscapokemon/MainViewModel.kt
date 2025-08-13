package com.example.buscapokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscapokemon.data.PokemonRepository
import com.example.buscapokemon.data.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val repository = PokemonRepository(RetrofitClient.pokemonApi)
    var pokemonDetails: String = ""
    var pokemonSprites: List<String> = emptyList()
    fun getPokemon(id: Int, onResult: (String, List<String>) -> Unit) {
        viewModelScope.launch {
            val (details, sprites) = repository.getPokemonData(id)
            withContext(Dispatchers.Main) {
                pokemonDetails = details
                pokemonSprites = sprites
                onResult(details, sprites)
            }
        }
    }
}