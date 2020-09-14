package com.java90.simplemoviesapp.ui.adapters.tvShows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.tvShows.DiscoverTvShow
import com.java90.simplemoviesapp.domain.utils.Constants.Companion.BASE_URL_IMAGE_POSTER
import kotlinx.android.synthetic.main.row_item.view.*

class TvShowItemAdapter(private val categoryItems: List<DiscoverTvShow>) : RecyclerView.Adapter<TvShowItemAdapter.TvShowsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return TvShowsViewHolder(view)
    }

    override fun getItemCount(): Int = categoryItems.size

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShowItem = categoryItems[position]

        holder.itemView.apply {
            tv_title_info.text = tvShowItem.name

            Glide.with(this)
                .load("${BASE_URL_IMAGE_POSTER}${tvShowItem.poster_path}")
                .centerCrop()
                .placeholder(R.drawable.ic_image_error)
                .into(iv_poster)

            setOnClickListener {
                onItemClickListener?.let {
                    it(tvShowItem)
                }
            }

        }
    }

    class TvShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    private var onItemClickListener: ((DiscoverTvShow) -> Unit)? = null
    fun setOnItemClickListener(listener : (DiscoverTvShow) -> Unit) {
        onItemClickListener = listener
    }

}