package com.example.starwars.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.starwars.R
import com.example.starwars.StarwarsViewModel
import com.example.starwars.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private val viewModel: StarwarsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCharacterBinding.inflate(inflater)
        viewModel.getCharacter()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = CharacterAdapter(CharacterListener { character ->
            viewModel.onCharacterClicked(character)
            findNavController()
                .navigate(R.id.action_nav_home_to_characterDetailFragment)
        })
        return binding.root
    }
}