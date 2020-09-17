package com.java90.simplemoviesapp.ui.view.starts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.java90.simplemoviesapp.R
import com.java90.simplemoviesapp.domain.utils.*
import com.java90.simplemoviesapp.ui.adapters.starts.PeopleAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_people.*
import kotlinx.android.synthetic.main.row_person.*

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private val viewModel : PeopleViewModel by viewModels()
    private lateinit var adapter: PeopleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().title = "Popular Starts"
        iniPeopleAdapter()

        viewModel.popularPeople.observe(viewLifecycleOwner,
            Observer {result->
                when(result) {
                    is Resource.Loading -> {
                        loading_people.showProgressBar()
                        tv_loading_people.showLoadingMessage()
                    }
                    is Resource.Success -> {

                        loading_people.hideProgressBar()
                        tv_loading_people.hideLoadingMessage()

                        result.data?.let{ listPerson->
                            adapter.differ.submitList(listPerson.results)
                        }
                    }
                    is Resource.Failure -> {
                        loading_people.hideProgressBar()
                        tv_loading_people.text = getString(R.string.errorLoading)
                    }
                }
            }
        )

        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putParcelable("person",it)
            }
            val extras = FragmentNavigatorExtras(
                iv_profile to "profile_picture",
                tv_personName to "person_name"
            )
            findNavController().navigate(R.id.action_peopleFragment_to_detailPersonFragment, bundle, null, extras)
        }
    }

    private fun iniPeopleAdapter() {
        recycler_people.layoutManager = GridLayoutManager(activity, 2)
        adapter = PeopleAdapter()
        recycler_people.adapter = adapter
    }
}