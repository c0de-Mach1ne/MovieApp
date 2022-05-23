package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.databinding.ActivityMovieRootBinding

class MainActivity : AppCompatActivity(), TransmitFragment {
    private lateinit var binding: ActivityMovieRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.frameLayoutContainer, DetailsFragment())
                commit()
            }
        }
    }

    override fun moveToFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayoutContainer, DetailsFragment())
            .addToBackStack(null)
            .commit()
    }
}