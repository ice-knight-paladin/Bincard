package com.example.bincard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.bincard.databinding.ItemLayoutBinding

class Adapter():RecyclerView.Adapter<ItemViewHolder>() {
    private val list = mutableListOf<ItemUi>()

    fun add(itemUi: ItemUi){
        list.add(itemUi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

}

class ItemViewHolder(
    private val binding: ItemLayoutBinding
) : ViewHolder(binding.root) {
    fun bind(value: ItemUi) {
        value.show(binding.elementTextView)
    }
}