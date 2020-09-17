package com.java90.simplemoviesapp.ui.adapters.starts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.starts.Person
import com.java90.simplemoviesapp.domain.utils.Constants.Companion.BASE_URL_IMAGE_POSTER
import kotlinx.android.synthetic.main.row_child_recycler.view.*
import kotlinx.android.synthetic.main.row_person.view.*

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Person>() {

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_person, parent, false)
        return PeopleViewHolder(view)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val person = differ.currentList[position]
        holder.bin(person)
    }

    inner class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bin(person: Person) {

            itemView.apply {

                tv_personName.text = person.name

                Glide.with(this)
                    .load("$BASE_URL_IMAGE_POSTER${person.profile_path}")
                    .centerCrop()
                    .placeholder(R.drawable.ic_image_error)
                    .into(iv_profile)

                setOnClickListener {
                    onItemClickListener?.let {
                        it(person)
                    }
                }
            }
        }
    }

    private var onItemClickListener: ((Person) -> Unit)? = null
    fun setOnItemClickListener(listener : (Person) -> Unit) {
        onItemClickListener = listener
    }
}