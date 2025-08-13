package com.example.buscapokemon.data

import com.example.buscapokemon.data.api.PokemonAPI

class PokemonRepository(private val api: PokemonAPI) {
    suspend fun getPokemonData(id: Int): Pair<String, List<String>> {
        val response = api.getPokemon(id)
        val details = "Name: ${response.name}, Weight: ${ response.weight }, Height: ${ response.height }"
        val sprites = listOfNotNull(
            response.sprites.frontDefault,
            response.sprites.backDefault,
            response.sprites.frontShiny,
            response.sprites.backShiny
        )
        return Pair(details, sprites)
    }
}