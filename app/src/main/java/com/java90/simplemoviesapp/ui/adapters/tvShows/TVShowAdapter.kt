package com.java90.simplemoviesapp.ui.adapters.series

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.series.CategoryTvShows

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.ItemViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<CategoryTvShows>() {

        override fun areContentsTheSame(oldItem: CategoryTvShows, newItem: CategoryTvShows): Boolean {
            return oldItem.categoryTitle == newItem.categoryTitle
        }

        override fun areItemsTheSame(oldItem: CategoryTvShows, newItem: CategoryTvShows): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_child_recycler, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int { return 5}

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}