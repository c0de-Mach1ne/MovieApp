package com.example.movieapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.adapters.ItemClickListener
import com.example.movieapp.model.Movie
import com.example.movieapp.adapters.MovieCardAdapter
import com.example.movieapp.data.JsonMovieRepository
import com.example.movieapp.databinding.FragmentMoviesListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ListFragment : Fragment() {
    private lateinit var binding: FragmentMoviesListBinding

    private lateinit var adapter: MovieCardAdapter
    private var scope = CoroutineScope(SupervisorJob())
    private var json: JsonMovieRepository? = null
    private var listMovie: List<Movie> = emptyList()
    private lateinit var listener: TransmitFragment

    private val clickListener = object: ItemClickListener<Movie>{
        override fun onClick(value: Movie){
            listener.moveToFragment(value)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView = view.findViewById(R.id.rv_card_movie)
        adapter = MovieCardAdapter(clickListener)
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.adapter = adapter
    }


    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scope.launch {
            Log.d("TAG JSON load", json!!.loadMovies().size.toString()) //20
            listMovie = json!!.loadMovies().toList()
            Log.d("TAG JSON inside", listMovie.size.toString()) //20
        }
        Log.d("TAG JSON outside", listMovie.size.toString()) //0

    }

    private fun updateData() {
        adapter.bindCardFilms(listMovie)
        adapter.notifyDataSetChanged()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        json = JsonMovieRepository(context)

        if(context is TransmitFragment){
            listener = context
        }

        Log.d("TAG JSON", json.toString())
    }

    override fun onDetach() {
        super.onDetach()
        json = null
    }
}