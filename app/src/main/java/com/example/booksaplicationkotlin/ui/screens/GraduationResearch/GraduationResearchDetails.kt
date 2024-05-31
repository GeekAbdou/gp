package com.example.myapplicationresearch.GraduationResearch


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.booksaplicationkotlin.databinding.PostGraduateResearchDetailsBinding


class GraduationResearchDetails : Fragment() {
    lateinit var binding: PostGraduateResearchDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding
        binding = PostGraduateResearchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.navigateToDetails.observe(viewLifecycleOwner) { category ->
//            category?.let {
//                // Perform navigation using NavController
//                val action = YourFragmentDirections.actionYourFragmentToDetailsFragment(category)
//                navController.navigate(action)


//        viewModel.navigateToDetails.observe(viewLifecycleOwner) { examResponse ->
//            examResponse?.let {
//                binding.apply {
//                    Glide.with(imageExam).load(it).into(imageExam)
//                }
//            }
//        }

//this uncomment it
//        viewModel.navigateToDetails.observe(viewLifecycleOwner) { imageUrl ->
//            imageUrl?.let {
//                Glide.with(binding.imageExam).load(it).into(binding.imageExam)
//            }
//        }

    }

    override fun onStart() {
        super.onStart()
        val research_name = arguments?.getString("research_name")
        research_name?.let {
            binding.textViewPostGraduateResearchName.text = research_name
        }

        val research_auther = arguments?.getString("research_auther")
        research_name?.let {
            binding.textViewAutherName.text = research_auther
        }

        val research_description = arguments?.getString("research_description")
        research_name?.let {
            binding.textViewPostGraduateResearchDescText.text = research_description
        }


        val research_supervisor = arguments?.getString("research_supervisor")
        research_name?.let {
            binding.textViewSupervisorName.text = research_supervisor
        }


        val research_field = arguments?.getString("research_field")
        research_name?.let {
            binding.textViewFieldName.text = research_field
        }


        val research_faculty = arguments?.getString("research_faculty")
        research_name?.let {
            binding.textViewFacultyName.text = research_faculty
        }

        val research_year = arguments?.getString("research_year")
        research_name?.let {
            binding.textViewYearName.text = research_year
        }


    }

}