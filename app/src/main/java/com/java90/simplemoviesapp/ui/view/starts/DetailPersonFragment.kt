package com.java90.simplemoviesapp.ui.view.starts

import android.os.Bundle
import android.transition.TransitionInflater
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
import com.java90.simplemoviesapp.domain.utils.Constants
import com.java90.simplemoviesapp.domain.utils.Resource
import com.java90.simplemoviesapp.domain.utils.hideProgressBar
import com.java90.simplemoviesapp.domain.utils.showProgressBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail_person.*

@AndroidEntryPoint
class DetailPersonFragment : Fragment() {

    private val viewModel : DetailPersonViewModel by viewModels()
    private val args: DetailPersonFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_detail_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.explode)
        val person = args.person

        tv_personName.text = person.name

        Glide.with(this)
            .load("${Constants.BASE_URL_IMAGE_POSTER}${person.profile_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_image_error)
            .into(iv_profile)

        viewModel.getDetailPerson(person.id)
        viewModel.loadDetailPerson.observe(viewLifecycleOwner,
            Observer {detailPerson ->
                when(detailPerson) {
                    is Resource.Loading -> {
                        loading_bio.showProgressBar()
                    }
                    is Resource.Success -> {
                        loading_bio.hideProgressBar()
                        detailPerson.data?.apply {
                            tv_bio.text = biography
                            tv_date_birth.text = place_of_birth
                        }
                    }
                    is Resource.Failure -> {
                        Snackbar.make(requireView(), R.string.errorLoading, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        )
    }

}