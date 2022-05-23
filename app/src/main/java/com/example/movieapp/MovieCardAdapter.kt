package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieCardAdapter: RecyclerView.Adapter<MovieListViewHolder>() {

    private var cardFilms = listOf<CardMovie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val viewCardMovie: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
            return MovieListViewHolder(viewCardMovie)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(cardFilms[position])
    }

    override fun getItemCount(): Int = cardFilms.size

    fun bindCardFilms(newCardFilms: List<CardMovie>){
        cardFilms = newCardFilms
    }

}