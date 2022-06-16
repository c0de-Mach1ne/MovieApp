package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.model.Movie
import com.example.movieapp.R
import com.example.movieapp.viewholders.MovieListViewHolder

interface ItemClickListener<T>{
    fun onClick(value: T)
}

class MovieCardAdapter(
    private val movieListener: ItemClickListener<Movie>
) : RecyclerView.Adapter<MovieListViewHolder>() {
    private var cardFilms = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val viewCardMovie: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)

        return MovieListViewHolder(viewCardMovie)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(cardFilms[position])

        holder.itemView.setOnClickListener {
            movieListener.onClick(getItem(position))
        }
    }

    private fun getItem(position: Int) = cardFilms[position]

    override fun getItemCount(): Int = cardFilms.size

    fun bindCardFilms(newCardFilms: List<Movie>) {
        cardFilms = newCardFilms
    }
}