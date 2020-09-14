package com.java90.simplemoviesapp.ui.view.tvShows

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.utils.*
import com.java90.simplemoviesapp.ui.adapters.tvShows.TVShowAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_tv_shows.*

@AndroidEntryPoint
class TvShowsFragment : Fragment() {

    private val viewModel: TvShowsViewModel by viewModels()
    private lateinit var adapter: TVShowAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        requireActivity().title = "Tv Shows"

        iniMainAdapter()

        viewModel.tvShowByCategory.observe(viewLifecycleOwner,
            Observer {result->

                when(result) {
                    is Resource.Loading -> {
                        tv_loading_tvShows.showLoadingMessage()
                        loading_tvShows.showProgressBar()
                    }
                    is Resource.Success -> {
                        tv_loading_tvShows.hideLoadingMessage()
                        loading_tvShows.hideProgressBar()
                        adapter.differ.submitList(result.data)
                    }
                    is Resource.Failure -> {
                        tv_loading_tvShows.text = getString(R.string.errorLoadingMovies)
                        context?.showToast("dddd")
                    }
                }
            }
        )
    }

    private fun iniMainAdapter() {
        main_recycler_tvShows.layoutManager = LinearLayoutManager(activity)
        adapter = TVShowAdapter()
        main_recycler_tvShows.adapter = adapter
    }
}