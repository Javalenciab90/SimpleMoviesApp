package com.java90.simplemoviesapp.ui.adapters.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.movies.DiscoverMovie
import com.java90.simplemoviesapp.domain.utils.Constants.Companion.BASE_URL_IMAGE_POSTER
import kotlinx.android.synthetic.main.row_item.view.*

class MoviesItemAdapter(private val categoryItems: List<DiscoverMovie>)
    : RecyclerView.Adapter<MoviesItemAdapter.MoviesItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)

        return MoviesItemViewHolder(view)
    }

    override fun getItemCount(): Int = categoryItems.size

    override fun onBindViewHolder(holder: MoviesItemViewHolder, position: Int) {

        val movieItem = categoryItems[position]

        holder.itemView.apply {
            tv_title_info.text = movieItem.title

            Glide.with(this)
                .load("$BASE_URL_IMAGE_POSTER${movieItem.poster_path}")
                .centerCrop()
                .placeholder(R.drawable.ic_image_error)
                .into(iv_poster)

            setOnClickListener {
                onItemClickListener?.let {
                    it(movieItem)
                }
            }
        }
    }

    class MoviesItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var onItemClickListener: ((DiscoverMovie) -> Unit)? = null
    fun setOnItemClickListener(listener : (DiscoverMovie) -> Unit) {
        onItemClickListener = listener
    }
}