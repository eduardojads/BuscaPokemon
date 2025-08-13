package com.example.buscapokemon.data.api.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    @SerializedName("id")val number: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
    )