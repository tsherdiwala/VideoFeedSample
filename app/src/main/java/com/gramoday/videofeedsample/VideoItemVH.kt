package com.gramoday.videofeedsample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind() {
        (itemView as TextView).text = "Video ID: $adapterPosition"
    }
}