package com.example.starwars.ui.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.starwars.R
import com.example.starwars.StarwarsViewModel
import com.example.starwars.databinding.FragmentFilmBinding
import com.example.starwars.databinding.FragmentFilmDetailBinding
import com.example.starwars.ui.film.FilmAdapter
import com.example.starwars.ui.characters.CharacterListener

class FilmFragment : Fragment() {
    private val viewModel: StarwarsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFilmBinding.inflate(inflater)
        viewModel.getFilm()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = FilmAdapter(FilmListener { film ->
            viewModel.onFilmClicked(film)
            findNavController()
                .navigate(R.id.action_nav_home_to_characterDetailFragment)
        })
        return binding.root
    }
}