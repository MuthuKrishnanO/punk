package com.zoho.punk.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zoho.punk.Beer
import com.zoho.punk.databinding.ListItemBeerBinding

class BeerListAdapter : ListAdapter<Beer, BeerViewHolder>(BeerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBeerBinding.inflate(inflater, parent, false)
        return BeerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val beer = getItem(position)
        holder.bind(beer)
    }
}

class BeerViewHolder(private val binding: ListItemBeerBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(beer: Beer) {
        binding.nameTextView.text = beer.name
        binding.taglineTextView.text = beer.tagline
   /*     Glide.with(binding.root)
            .load(beer.image_url)
            .into(binding.beerImageView)*/
    }
}

class BeerDiffCallback : DiffUtil.ItemCallback<Beer>() {
    override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
        return oldItem == newItem
    }
}
