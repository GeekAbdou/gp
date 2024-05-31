package com.example.myapplicationfinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.booksaplicationkotlin.databinding.ActivityDetailsExamBinding


class fragmetnDetailsExam : Fragment() {
    lateinit var binding: ActivityDetailsExamBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding
        binding = ActivityDetailsExamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onStart() {
        super.onStart()
        val imageUrl = arguments?.getString("imageUrl")
        imageUrl?.let {
            Glide.with(binding.imageExam2).load(it).into(binding.imageExam2)
        }
    }

}
