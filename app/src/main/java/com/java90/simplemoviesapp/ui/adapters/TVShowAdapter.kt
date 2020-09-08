package com.java90.simplemoviesapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.TVShow
import kotlinx.android.synthetic.main.layout_item.view.*

class ItemTVShowAdapter : RecyclerView.Adapter<ItemTVShowAdapter.ItemViewHolder>() {

    private val tvShowList = listOf(
        TVShow(1,"TVShow Title1"),
        TVShow(2,"TVShow Title2"),
        TVShow(3,"TVShow Title3"),
        TVShow(4,"TVShow Title4"),
        TVShow(5,"TVShow Title5")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = tvShowList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemTVShow = tvShowList[position]
        holder.bin(itemTVShow)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bin(itemTVShow: TVShow){
            itemView.apply {
                tv_name.text = itemTVShow.name
            }
        }
    }
}