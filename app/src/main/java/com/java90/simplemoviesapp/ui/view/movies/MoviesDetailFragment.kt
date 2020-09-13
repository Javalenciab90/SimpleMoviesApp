package com.java90.simplemoviesapp.ui.view.detailMovie

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.models.movies.DetailMovie
import com.java90.simplemoviesapp.domain.models.movies.DiscoverMovie
import com.java90.simplemoviesapp.domain.utils.Constants.Companion.BASE_URL_IMAGE_BACKGROUND
import com.java90.simplemoviesapp.domain.utils.Resource
import com.java90.simplemoviesapp.domain.utils.hideProgressBar
import com.java90.simplemoviesapp.domain.utils.showProgressBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies_detail.*

@AndroidEntryPoint
class MoviesDetailFragment : Fragment() {

    private val viewModel: DetailMovieViewModel by viewModels()
    private val args: MoviesDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movies_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        requireActivity().title = "Details Movie"


        val discoverMovie = args.discoverMovie
        setUpInfoMovie(discoverMovie)
    }

    private fun setUpInfoMovie(movie: DiscoverMovie) {

        tv_title_name.text = movie.title
        tv_language.text = movie.original_language
        tv_rate.text = (movie.vote_average/2).toString()
        tv_overview.apply {
            movementMethod = ScrollingMovementMethod()
            text = movie.overview
        }
        tv_date.text = movie.release_date
        ratingBar.rating = String.format("%.0f", (movie.vote_average / 2).toFloat()).toFloat()

        Glide.with(this)
            .load("$BASE_URL_IMAGE_BACKGROUND${movie.backdrop_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_image_error)
            .into(iv_background_poster)
    }
}