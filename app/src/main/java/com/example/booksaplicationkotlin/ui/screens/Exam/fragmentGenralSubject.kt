package com.example.myapplicationfinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.ActivitySubjectBinding

class fragmentGenralSubject : Fragment() {
    lateinit var binding: ActivitySubjectBinding
    val fragmentExam = fragmentExam()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding

        binding = ActivitySubjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.ButtonSubject1.setOnClickListener {v->
//            Navigation.findNavController(v).navigate(R.id.action_fragment_subject1_to_fragment_exam)
//
//        }

        binding.ButtonSubject1.setOnClickListener {
            val bundle = Bundle().apply {
                putString("subjectName", binding.ButtonSubject1.text.toString())
            }
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_fragment_subject1_to_fragment_exam, bundle)
        }

    }


}