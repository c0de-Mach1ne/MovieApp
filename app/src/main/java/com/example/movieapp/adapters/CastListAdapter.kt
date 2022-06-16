package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.Actor
import com.example.movieapp.viewholders.CastListViewHolder

class CastListAdapter() : RecyclerView.Adapter<CastListViewHolder>() {

    private var castList = listOf<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_cast, parent, false)
        return CastListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastListViewHolder, position: Int) {
        holder.onBind(castList[position])
    }

    override fun getItemCount(): Int = castList.size

    fun bindCastList(actor: List<Actor>) {
        castList = actor
    }
}