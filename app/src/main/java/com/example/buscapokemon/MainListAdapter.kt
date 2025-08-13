package com.example.buscapokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.buscapokemon.databinding.ItemSpriteBinding

class MainListAdapter :
    RecyclerView.Adapter<MainListAdapter.SpriteViewHolder>() {
    private var sprites: List<String> = emptyList()
    fun submitList(list: List<String>) {
        sprites = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            SpriteViewHolder {
        // Utilizando ViewBinding para inflar o layout do item
        val binding =
            ItemSpriteBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        return SpriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpriteViewHolder, position:
    Int) {
        val spriteUrl = sprites[position]

        Glide.with(holder.binding.root.context).load(spriteUrl).into(holder.binding.ivSprite)
    }
    override fun getItemCount() = sprites.size
    class SpriteViewHolder(val binding: ItemSpriteBinding) :
        RecyclerView.ViewHolder(binding.root)
}
