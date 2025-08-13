package com.example.buscapokemon.data

import com.example.buscapokemon.data.api.PokemonAPI
import com.example.buscapokemon.domain.model.Pokemon

class PokemonRepository(private val api: PokemonAPI) {
    suspend fun getPokemonData(id: Int): Pokemon {
        val response = api.getPokemon(id)
        val name = "Name: ${response.name} "
        //val weight = "Weight: ${ response.weight } "
        //val height = "Height: ${ response.height }"
        val sprites = listOfNotNull(
            response.sprites.frontDefault,
            response.sprites.backDefault,
            response.sprites.frontShiny,
            response.sprites.backShiny
        )
        return Pokemon(id, name, sprites)
    }
}