package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CastListAdapter: RecyclerView.Adapter<CastListViewHolder>() {

    private var castList = listOf<Casts>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_cast, parent, false)
        return CastListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastListViewHolder, position: Int) {
        holder.onBind(castList[position])
    }

    override fun getItemCount(): Int = castList.size

    fun bindCastList(newCastList: List<Casts>){
        castList = newCastList
    }
}