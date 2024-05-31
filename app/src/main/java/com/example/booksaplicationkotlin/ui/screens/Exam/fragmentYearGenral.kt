package com.example.myapplicationfinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.ActivityYearGeneralBinding

class fragmentYearGenral : Fragment() {
    private lateinit var binding: ActivityYearGeneralBinding
    private val fragmentTerm = fragmentGenralSubject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding
        binding = ActivityYearGeneralBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstyear.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_YearGenral_to_fragment_subject1)

        }
        binding.secondyear.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_YearGenral_to_fragment_subject1)

        }
        binding.thiredcs.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_YearGenral_to_fragment_subject1)

        }
        binding.thiredis.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_YearGenral_to_fragment_subject1)

        }
        binding.forthis.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_YearGenral_to_fragment_subject1)

        }
        binding.fourthcs.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_fragment_YearGenral_to_fragment_subject1)

        }

    }


}








