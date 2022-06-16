package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.databinding.ActivityMovieRootBinding
import com.example.movieapp.model.Movie

class MainActivity : AppCompatActivity(), TransmitFragment {

    private lateinit var binding: ActivityMovieRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.frameLayoutContainer, ListFragment())
                commit()
            }
        }
    }

    override fun moveToFragment(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutContainer, DetailsFragment.newInstance(movie))
            .addToBackStack(null)
            .commit()
    }
}