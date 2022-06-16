package com.example.movieapp.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.model.Actor

class CastListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val fullName: TextView = itemView.findViewById(R.id.tv_cast_first_name)
    private val castAvatar: ImageView = itemView.findViewById(R.id.iv_cast_avatar)

    fun onBind(actors: Actor) {
        Glide.with(context)
            .load(actors.imageUrl)
            .into(castAvatar)

        fullName.text = actors.name
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context