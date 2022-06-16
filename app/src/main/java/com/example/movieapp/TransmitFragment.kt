package com.example.movieapp

import com.example.movieapp.model.Movie

interface TransmitFragment {
    fun moveToFragment(movie: Movie)
}