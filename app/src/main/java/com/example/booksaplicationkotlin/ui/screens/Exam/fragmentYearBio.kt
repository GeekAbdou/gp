package com.example.myapplicationfinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.ActivityYearBioBinding

class fragmentYearBio : Fragment() {
    lateinit var binding: ActivityYearBioBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding
        binding = ActivityYearBioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstyear.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_Yearbio_to_fragment_biosubject)

        }
        binding.secondyear.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_Yearbio_to_fragment_biosubject)

        }
        binding.thired.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_Yearbio_to_fragment_biosubject)

        }
        binding.fourth.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_Yearbio_to_fragment_biosubject)

        }


    }


}