package com.example.myapplicationfinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.ActivityBiosubjectBinding


class fragmentBioSubject : Fragment(){

    lateinit var  binding : ActivityBiosubjectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityBiosubjectBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.buttonSubject1.setOnClickListener {v->
//            Navigation.findNavController(v).navigate(R.id.action_fragment_biosubject_to_fragment_exam)
//        }



        binding.buttonSubject1.setOnClickListener {
            val bundle = Bundle().apply {
                putString("subjectName", binding.buttonSubject1.text.toString())
            }
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_fragment_biosubject_to_fragment_exam, bundle)
        }


    }

}