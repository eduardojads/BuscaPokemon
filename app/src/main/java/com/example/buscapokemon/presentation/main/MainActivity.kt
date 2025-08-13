package com.example.buscapokemon.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buscapokemon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter : MainListAdapter
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding .inflate( layoutInflater)
        setContentView( binding.root)
        mainAdapter = MainListAdapter()
        binding.rvSprites .layoutManager = LinearLayoutManager( this,
            LinearLayoutManager .HORIZONTAL, false)
        binding.rvSprites .adapter = mainAdapter
        // Configurando o clique do botão de busca
        binding.btnSearch .setOnClickListener {
            val id = binding.etPokemonId .text.toString(). toIntOrNull()
            if (id != null) {
                viewModel.getPokemon(id)
            }
        }
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.pokemonResponse.observe(this) { pokemon ->
            binding.tvPokemonDetails .text = pokemon.name
            mainAdapter .submitList(pokemon.imagesUrl)
        }
    }
}