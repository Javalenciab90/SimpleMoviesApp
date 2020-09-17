package com.java90.simplemoviesapp.ui.view.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.utils.*
import com.java90.simplemoviesapp.ui.adapters.movies.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies.*

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val viewModel : MoviesViewModel by viewModels()
    private lateinit var adapter: MoviesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        requireActivity().title = "Movies"

        iniMainAdapter()

        viewModel.moviesByCategory.observe(viewLifecycleOwner,
            Observer {result ->

                when(result) {
                    is Resource.Loading -> {
                        tv_loading_movies.showLoadingMessage()
                        loading_movies.showProgressBar()
                    }
                    is Resource.Success -> {
                        tv_loading_movies.hideLoadingMessage()
                        loading_movies.hideProgressBar()
                        adapter.differ.submitList(result.data)
                    }
                    is Resource.Failure -> {
                        tv_loading_movies.text = getString(R.string.errorLoading)
                        context?.showToast(result.toString())
                    }
                }
            }
        )
    }

    private fun iniMainAdapter() {
        main_recycler_movies.layoutManager = LinearLayoutManager(activity)
        adapter = MoviesAdapter()
        main_recycler_movies.adapter = adapter
    }
}