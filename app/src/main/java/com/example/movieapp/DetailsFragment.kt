package com.example.movieapp

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.adapters.CastListAdapter
import com.example.movieapp.databinding.FragmentMoviesDetailsBinding
import com.example.movieapp.model.Movie

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentMoviesDetailsBinding
    private lateinit var adapter: CastListAdapter

    private val movie: Movie
        get() = requireArguments().getSerializable(ARG_MOVIE) as Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesDetailsBinding.inflate(layoutInflater, container, false)

        val starsImages = listOf(
            binding.ivStarIconP1,
            binding.ivStarIconP2,
            binding.ivStarIconP3,
            binding.ivStarIconP4,
            binding.ivStarIconM5
        )

        binding.tvNameOfFilm.text = movie.title
        binding.tvAgeRestrictions.text = movie.pgAge.toString()
        binding.tvNumOfReview.text = movie.reviewCount.toString()
        binding.tvGenreOfFilms.text = movie.genres.joinToString { it.name }
        binding.tvStorylineDescription.text = movie.storyLine

        Glide.with(binding.poster.context)
            .load(movie.imageUrl)
            .into(binding.poster)

        starsImages.forEachIndexed { index, imageView ->
            imageView.let {
                val colorId = if (movie.rating > index) R.color.pink_light else R.color.gray_dark
                ImageViewCompat.setImageTintList(
                    imageView, ColorStateList.valueOf(
                        ContextCompat.getColor(imageView.context, colorId)
                    )
                )
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView? = view.findViewById(R.id.rv_cast_list)
        adapter = CastListAdapter()
        recycler?.layoutManager =
            GridLayoutManager(requireContext(), 1, RecyclerView.HORIZONTAL, false)
        recycler?.adapter = adapter

        updateDate()
    }

    private fun updateDate() {
        adapter.bindCastList(movie.actors)
        adapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()
        updateDate()
    }

    companion object {
        private const val ARG_MOVIE = "ARG_MOVIE"

        fun newInstance(movie: Movie): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundleOf(ARG_MOVIE to movie)
            return fragment
        }
    }
}