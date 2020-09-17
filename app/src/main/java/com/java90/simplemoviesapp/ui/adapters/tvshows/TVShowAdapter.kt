package com.java90.simplemoviesapp.ui.adapters.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.tvShows.CategoryTvShows
import com.java90.simplemoviesapp.domain.models.tvShows.DiscoverTvShow
import kotlinx.android.synthetic.main.row_child_recycler.view.*

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TvShowViewHolder>() {

    private lateinit var itemAdapter: TvShowItemAdapter

    private val differCallback = object : DiffUtil.ItemCallback<CategoryTvShows>() {

        override fun areContentsTheSame(oldItem: CategoryTvShows, newItem: CategoryTvShows): Boolean {
            return oldItem.categoryTitle == newItem.categoryTitle
        }

        override fun areItemsTheSame(oldItem: CategoryTvShows, newItem: CategoryTvShows): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_child_recycler, parent, false)

        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val category = differ.currentList[position]

        iniItemRecycler(holder.itemView.childRecycler, category.categoryItems)

        holder.itemView.apply {
            tv_categoryName.text = category.categoryTitle

            itemAdapter.setOnItemClickListener {
                val bundle = Bundle().apply {
                    putParcelable("discoverTvShow", it)
                }
                findNavController().navigate(R.id.action_seriesFragment_to_seriesDetailFragment, bundle)
            }
        }

    }

    class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private fun iniItemRecycler(recyclerView: RecyclerView, categoryItems: List<DiscoverTvShow>) {
        itemAdapter = TvShowItemAdapter(categoryItems)
        recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }


}