package com.java90.simplemoviesapp.ui.adapters.movies

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
import com.java90.simplemoviesapp.domain.models.movies.CategoryMovies
import com.java90.simplemoviesapp.domain.models.movies.DiscoverMovie
import kotlinx.android.synthetic.main.row_child_recycler.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private lateinit var itemAdapter: CategoryItemAdapter

    private val differCallBack = object : DiffUtil.ItemCallback<CategoryMovies>() {

        override fun areContentsTheSame(oldItem: CategoryMovies, newItem: CategoryMovies): Boolean {
            return oldItem.categoryTitle == newItem.categoryTitle
        }

        override fun areItemsTheSame(oldItem: CategoryMovies, newItem: CategoryMovies): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_child_recycler, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val category = differ.currentList[position]

        iniItemRecycler(holder.itemView.childRecycler, category.categoryItems)

        holder.itemView.apply {
            tv_categoryName.text = category.categoryTitle

            itemAdapter.setOnItemClickListener {
                val bundle = Bundle().apply {
                    putParcelable("discoverMovie", it)
                }
                findNavController().navigate(R.id.action_moviesFragment_to_detailMovieFragment, bundle)
            }
        }
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private fun iniItemRecycler(recyclerView: RecyclerView, categoryItems: List<DiscoverMovie>) {
        itemAdapter = CategoryItemAdapter(categoryItems)
        recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }
}