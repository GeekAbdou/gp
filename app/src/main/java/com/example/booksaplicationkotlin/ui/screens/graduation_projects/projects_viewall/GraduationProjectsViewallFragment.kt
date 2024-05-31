package com.example.readx.ui.screens.graduation_projects.projects_viewall

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentGraduationProjectsViewallBinding
import com.example.booksaplicationkotlin.model.GradProject
import com.example.booksaplicationkotlin.ui.screens.graduation_projects.search.GradProjectInteractionListener
import com.example.booksaplicationkotlin.ui.screens.graduation_projects.search.GraduationProjectsAdapter
import com.example.readx.ui.base.BaseFragment
import com.example.readx.ui.screens.graduation_projects.GraduationProjectsFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GraduationProjectsViewallFragment() :
    BaseFragment<FragmentGraduationProjectsViewallBinding>() {
    override val layoutIdFragment = R.layout.fragment_graduation_projects_viewall
    override val viewModel: GraduationProjectsViewallViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewGraduationProject.adapter = GraduationProjectsAdapter(object :
            GradProjectInteractionListener {
            override fun onClickGradProject(gradProject: GradProject) {
                val action =
                    GraduationProjectsFragmentDirections
                        .actionGraduationProjectsFragmentToGPDetailsFragment(
                        gradProject
                    )
                findNavController().navigate(action)
            }
        })
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: GraduationProjectsViewallNavigationEvent) {
        val action = when (event) {
            is GraduationProjectsViewallNavigationEvent.NavigateToProject ->
                GraduationProjectsViewallFragmentDirections.actionGraduationProjectsViewallFragmentToGPDetailsFragment(
                    event.gradProject
                )


        }
        findNavController().navigate(action)

    }


}