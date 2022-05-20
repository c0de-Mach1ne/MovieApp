package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieCardAdapter: RecyclerView.Adapter<MovieListViewHolder>() {

    private var cardFilms = listOf<CardFilms>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_film_data, parent, false)
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(cardFilms[position])
    }

    override fun getItemCount(): Int = cardFilms.size

    fun bindCardFilms(newCardFilms: List<CardFilms>){
        cardFilms = newCardFilms
    }
}