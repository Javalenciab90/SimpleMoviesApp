package com.java90.simplemoviesapp.ui.view.detailTvShow

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.tvShows.DiscoverTvShow
import com.java90.simplemoviesapp.domain.utils.Constants.Companion.BASE_URL_IMAGE_BACKGROUND
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tv_show_detail.*

class TvShowDetailFragment : Fragment() {

    private val args: TvShowDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_tv_show_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        requireActivity().title = "Details TvShow"

        val discoverTvShow = args.discoverTvShow
        setUpInfoTvShow(discoverTvShow)
/*
        viewModel.getDetailTvShowById(discoverTvShow.id)
        viewModel.detailTvShow.observe(viewLifecycleOwner,
            Observer {responseDetailTvShow->
                when(responseDetailTvShow) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        responseDetailTvShow.data?.let {
                            tv_nameShow.text = it.name
                            setUpInfoTvShow(it)
                        }
                    }
                    is Resource.Failure -> {

                    }
                }

            }
        )

         */
    }



    private fun setUpInfoTvShow(tvShow: DiscoverTvShow) {

        tv_nameShow.text = tvShow.name
        tv_rate_tvShow.text = (tvShow.vote_average/2).toString()
        tv_overview_show.apply {
            movementMethod = ScrollingMovementMethod()
            text = tvShow.overview
        }
        //tv_episodes.text = tvShow.number_of_episodes.toString()
        //tv_seasons.text = tvShow.number_of_seasons.toString()
        ratingBar_tvShow.rating = String.format("%.0f", (tvShow.vote_average/2).toFloat()).toFloat()

        Glide.with(this)
            .load("${BASE_URL_IMAGE_BACKGROUND}${tvShow.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_image_error)
            .into(iv_tvShow_poster)
    }
}