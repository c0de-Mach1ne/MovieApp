package com.example.movieapp

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

open class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val poster: ImageView = itemView.findViewById(R.id.iv_poster_of_films)
    private val favoriteFilm: ImageView = itemView.findViewById(R.id.iv_like_of_films)
    private val ageRestrictions: TextView = itemView.findViewById(R.id.tv_age_restrictions)
    private val genreOfFilms: TextView = itemView.findViewById(R.id.tv_genre_of_films)
    private val movieLength: TextView = itemView.findViewById(R.id.tv_movie_length)
    private val nameOfFilm: TextView = itemView.findViewById(R.id.tv_name_of_film)
    private val numOfReview: TextView = itemView.findViewById(R.id.tv_num_of_review)

    private val starIcon1: ImageView = itemView.findViewById(R.id.iv_starIcon_p1)
    private val starIcon2: ImageView = itemView.findViewById(R.id.iv_starIcon_p2)
    private val starIcon3: ImageView = itemView.findViewById(R.id.iv_starIcon_p3)
    private val starIcon4: ImageView = itemView.findViewById(R.id.iv_starIcon_p4)
    private val starIcon5: ImageView = itemView.findViewById(R.id.iv_starIcon_p5)

    @SuppressLint("SetTextI18n")
    fun onBind(cardMovie: CardMovie) {
        Glide.with(context)
            .load(cardMovie.poster_of_cardFilms)
            .into(poster)

        if (cardMovie.isFavoriteFilm)
            favoriteFilm.setImageResource(R.drawable.positive_like)

        ageRestrictions.text = "+${cardMovie.age_restrictions}"
        genreOfFilms.text = cardMovie.genre_of_films
        movieLength.text = "${cardMovie.movie_length} MIN"
        nameOfFilm.text = cardMovie.name_of_films
        numOfReview.text = "${cardMovie.num_of_review} REVIEWS"

        when (cardMovie.positive_ratings) {
            1 -> {
                starIcon1.setImageResource(R.drawable.star_icon_plus_8px)
            }

            2 -> {
                starIcon2.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon1.setImageResource(R.drawable.star_icon_plus_8px)
            }

            3 -> {
                starIcon3.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon2.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon1.setImageResource(R.drawable.star_icon_plus_8px)
            }

            4 -> {
                starIcon4.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon3.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon2.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon1.setImageResource(R.drawable.star_icon_plus_8px)
            }

            5 -> {
                starIcon5.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon4.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon3.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon2.setImageResource(R.drawable.star_icon_plus_8px)
                starIcon1.setImageResource(R.drawable.star_icon_plus_8px)
            }
        }
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context