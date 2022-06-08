package com.example.starwars.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.databinding.CharacterCardBinding

class HomeScreenAdapter : PagingDataAdapter<PeoplePresentation, HomeScreenAdapter.HomeViewHolder>(DiffUtilCallback()) {
    class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val binding = CharacterCardBinding.bind(itemView)

        fun setupView(character : PeoplePresentation) {
            binding.character = character
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val character = getItem(position)

        character?.let {
            holder.setupView(character)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.character_card, parent, false)
        return HomeViewHolder(inflater)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<PeoplePresentation>() {
        override fun areItemsTheSame(oldItem: PeoplePresentation, newItem: PeoplePresentation): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PeoplePresentation, newItem: PeoplePresentation): Boolean {
            return oldItem == newItem
        }

    }
}