package com.example.starwars.ui.starships

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.starwars.R
import com.example.starwars.StarwarsViewModel
import com.example.starwars.databinding.FragmentStarshipsBinding

class StarshipsFragment : Fragment() {
    val viewModel: StarwarsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentStarshipsBinding.inflate(inflater)
        viewModel.getStarship()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = StarshipsAdapter(StarshipsListener { starship ->
            viewModel.onStarshipClicked(starship)
            findNavController()
                .navigate(R.id.action_starshipsFragment_to_starshipsDetailFragment)
        })
        return binding.root
    }
}