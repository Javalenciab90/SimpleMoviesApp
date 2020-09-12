package com.java90.simplemoviesapp.ui.adapters.series

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.java90.simplemoviesapp.R

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int { return 0}

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}