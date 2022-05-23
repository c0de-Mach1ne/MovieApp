package com.example.movieapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CastListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val firstName: TextView = itemView.findViewById(R.id.tv_cast_first_name)
    private val secondName: TextView = itemView.findViewById(R.id.tv_cast_second_name)
    private val castAvatar: ImageView = itemView.findViewById(R.id.iv_cast_avatar)

    fun onBind(casts: Casts) {
        Glide.with(context)
            .load(casts.avatar)
            .into(castAvatar)

        firstName.text = casts.firstName
        secondName.text = casts.secondName
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context