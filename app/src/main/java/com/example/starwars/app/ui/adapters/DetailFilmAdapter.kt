package com.example.starwars.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.app.models.FilmPresentation
import com.example.starwars.databinding.FilmDetailBinding

class DetailFilmAdapter(private val filmDataList : List<FilmPresentation>) : RecyclerView.Adapter<DetailFilmAdapter.DetailViewHolder>() {
    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = FilmDetailBinding.bind(itemView)

        fun setupView(film : FilmPresentation) {
            binding.film = film
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailFilmAdapter.DetailViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.film_detail, parent, false)
        return DetailViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: DetailFilmAdapter.DetailViewHolder, position: Int) {
        val positionalFilm = filmDataList[position]
        holder.setupView(positionalFilm)
    }

    override fun getItemCount(): Int {
        return filmDataList.size
    }
}