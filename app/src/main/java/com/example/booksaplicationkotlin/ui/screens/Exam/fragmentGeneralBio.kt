package com.example.myapplicationfinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.ActivityGenralBioBinding


class fragmentGeneralBio : Fragment() {

    lateinit var binding: ActivityGenralBioBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding
        binding = ActivityGenralBioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.genral.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_general_bio_to_fragment_YearGenral)
        }
        binding.bio.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_general_bio_to_fragment_Yearbio)

        }


    }


}