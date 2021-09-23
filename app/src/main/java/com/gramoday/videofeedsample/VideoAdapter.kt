package com.gramoday.videofeedsample

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter : RecyclerView.Adapter<VideoItemVH>() {

    companion object {
        private var count = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoItemVH {

        Log.d("adapter", "Count: ${++count}")

        return LayoutInflater
            .from(parent.context)
            .inflate(
                android.R.layout.simple_list_item_1,
                parent,
                false
            )
            .let {
                VideoItemVH(it)
            }
    }

    override fun onBindViewHolder(holder: VideoItemVH, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 100
}