package com.example.movieapp

/*
private val poster: ImageView = itemView.findViewById(R.id.iv_poster_of_films)
    private val like: ImageView = itemView.findViewById(R.id.iv_like_of_films)
    private val ageRestrictions: TextView = itemView.findViewById(R.id.tv_age_restrictions)
    private val genreOfFilms: TextView = itemView.findViewById(R.id.tv_genre_of_films)
    private val movieLength: TextView = itemView.findViewById(R.id.tv_movie_length)
    private val nameOfFilmCard: TextView = itemView.findViewById(R.id.tv_name_of_film_card)
    private val numOfReview: TextView = itemView.findViewById(R.id.tv_num_of_review)

    private val starIcon1: ImageView = itemView.findViewById(R.id.iv_starIcon_p1)
    private val starIcon2: ImageView = itemView.findViewById(R.id.iv_starIcon_p2)
    private val starIcon3: ImageView = itemView.findViewById(R.id.iv_starIcon_p3)
    private val starIcon4: ImageView = itemView.findViewById(R.id.iv_starIcon_p4)
    private val starIcon5: ImageView = itemView.findViewById(R.id.iv_starIcon_p5)
 */

data class CardMovie(
    val name_of_films: String,
    val poster_of_cardFilms: String,
    val age_restrictions: Int,
    val genre_of_films: String,
    val movie_length: Int,
    val num_of_review: Int,
    val positive_ratings: Int,
    val isFavoriteFilm: Boolean
)