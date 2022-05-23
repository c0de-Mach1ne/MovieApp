package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.FragmentMoviesListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentMoviesListBinding
    private var clickListener: TransmitFragment? = null
    private lateinit var adapter: MovieCardAdapter

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
        adapter = MovieCardAdapter()
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.adapter = adapter

        view.findViewById<Button>(R.id.btnPISYA).setOnClickListener {
            clickListener!!.moveToFragment()
        }
    }


    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        adapter.bindCardFilms(SourceCardMovie().getCardMovie())
        adapter.notifyDataSetChanged()
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is TransmitFragment) {
//            clickListener = context
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        clickListener = null
//    }
}