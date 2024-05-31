package com.example.readx.ui.screens.graduation_projects.gp_plagiarism

import androidx.fragment.app.viewModels
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentGraduationProjectPlagiarismBinding
import com.example.readx.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class GraduationProjectPlagiarismFragment() :
    BaseFragment<FragmentGraduationProjectPlagiarismBinding>() {
    override val layoutIdFragment = R.layout.fragment_graduation_project_plagiarism
    override val viewModel: GraduationProjectPlagiarismViewModel by viewModels()
}