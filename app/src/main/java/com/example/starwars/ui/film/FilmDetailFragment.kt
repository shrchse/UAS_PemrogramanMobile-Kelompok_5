package com.example.starwars.ui.film

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.starwars.R
import com.example.starwars.StarwarsViewModel
import com.example.starwars.databinding.FragmentFilmDetailBinding

class FilmDetailFragment : Fragment() {
    private val viewModel: StarwarsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFilmDetailBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModel = viewModel
        return binding.root
    }
}