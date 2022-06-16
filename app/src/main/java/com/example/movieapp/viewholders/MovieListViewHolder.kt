package com.example.movieapp.viewholders

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.model.Movie
import com.bumptech.glide.Glide
import com.example.movieapp.R

open class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val poster: ImageView = itemView.findViewById(R.id.iv_poster_of_films)
    private val favoriteFilm: ImageView = itemView.findViewById(R.id.iv_like_of_films)
    private val ageRestrictions: TextView = itemView.findViewById(R.id.tv_age_restrictions)
    private val genreOfFilms: TextView = itemView.findViewById(R.id.tv_genre_of_films)
    private val movieLength: TextView = itemView.findViewById(R.id.tv_movie_length)
    private val nameOfFilm: TextView = itemView.findViewById(R.id.tv_name_of_film)
    private val numOfReview: TextView = itemView.findViewById(R.id.tv_num_of_review)

    private val starsImages = listOf<ImageView>(
        itemView.findViewById(R.id.iv_starIcon_p1),
        itemView.findViewById(R.id.iv_starIcon_p2),
        itemView.findViewById(R.id.iv_starIcon_p3),
        itemView.findViewById(R.id.iv_starIcon_p4),
        itemView.findViewById(R.id.iv_starIcon_p5)
    )

    @SuppressLint("SetTextI18n")
    fun onBind(movie: Movie) {
        Glide.with(context)
            .load(movie.imageUrl)
            .into(poster)

        if (movie.isLiked)
            favoriteFilm.setImageResource(R.drawable.positive_like)

        ageRestrictions.text = "+${movie.pgAge}"
        genreOfFilms.text = movie.genres.joinToString { it.name }
        movieLength.text = "${movie.runningTime} MIN"
        nameOfFilm.text = movie.title
        numOfReview.text = "${movie.reviewCount} REVIEWS"

        starsImages.forEachIndexed{ index, imageView ->
            val colorId = if (movie.rating > index) R.color.pink_light else R.color.gray_dark
            ImageViewCompat.setImageTintList(
                imageView, ColorStateList.valueOf(
                    ContextCompat.getColor(imageView.context, colorId)
                )
            )
        }
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context