package me.federicopeyrani.duetto.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import me.federicopeyrani.duetto.R
import me.federicopeyrani.duetto.databinding.FragmentFavouriteBinding

class FragmentFavourite : Fragment(R.layout.fragment_favourite) {

    private lateinit var binding: FragmentFavouriteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavouriteBinding.bind(view)
    }
}