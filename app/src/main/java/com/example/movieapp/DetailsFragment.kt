package com.example.movieapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.FragmentMoviesDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentMoviesDetailsBinding
    private lateinit var adapter: CastListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView? = view.findViewById(R.id.rv_cast_list)
        adapter = CastListAdapter()
        recycler?.layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.HORIZONTAL, false)
        recycler?.adapter = adapter
    }

    private fun updateDate() {
        adapter.bindCastList(SourceCasts().getCasts())
        adapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()
        updateDate()
    }
}