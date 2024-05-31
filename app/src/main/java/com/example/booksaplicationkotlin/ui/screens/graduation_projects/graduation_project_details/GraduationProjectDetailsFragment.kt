package com.example.readx.ui.screens.graduation_projects.graduation_project_details

import androidx.fragment.app.viewModels
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentGraduationProjectDetailsBinding
import com.example.readx.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class GraduationProjectDetailsFragment() :
    BaseFragment<FragmentGraduationProjectDetailsBinding>() {
    override val layoutIdFragment = R.layout.fragment_graduation_project_details
    override val viewModel: GraduationProjectDetailsViewModel by viewModels()
}