package com.java90.simplemoviesapp.ui.view.series

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.java90.simplemoviesapp.R

class SeriesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_series, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
    }

}