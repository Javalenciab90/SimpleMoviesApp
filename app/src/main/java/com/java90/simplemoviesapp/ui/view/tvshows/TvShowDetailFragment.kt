package com.java90.simplemoviesapp.ui.view.tvShows

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.tvShows.DiscoverTvShow
import com.java90.simplemoviesapp.domain.utils.Constants.Companion.BASE_URL_IMAGE_BACKGROUND
import kotlinx.android.synthetic.main.fragment_movies_detail.*

class TvShowDetailFragment : Fragment() {

    private val args: TvShowDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_movies_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        requireActivity().title = "Details TvShow"

        val tvShow = args.discoverTvShow

        setUpInfoTvShow(tvShow)
    }

    private fun setUpInfoTvShow(tvShow: DiscoverTvShow) {

        tv_title_name.text = tvShow.name
        tv_rate.text = (tvShow.vote_average/2).toString()
        tv_overview.apply {
            movementMethod = ScrollingMovementMethod()
            text = tvShow.overview
        }
        ratingBar.rating = String.format("%.0f", (tvShow.vote_average/2).toFloat()).toFloat()
        tv_date.text = tvShow.first_air_date
        Glide.with(this)
            .load("${BASE_URL_IMAGE_BACKGROUND}${tvShow.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_image_error)
            .into(iv_background_poster)
    }
}