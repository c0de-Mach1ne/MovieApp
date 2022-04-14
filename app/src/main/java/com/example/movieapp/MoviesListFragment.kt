package com.example.movieapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.databinding.FragmentMoviesListBinding

class MoviesListFragment : Fragment() {
    private lateinit var binding: FragmentMoviesListBinding
    private var clickListener: TransmitFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ConstraintLayoutCardMovie.setOnClickListener{
            clickListener?.moveToFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is TransmitFragment) {
            clickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }
}