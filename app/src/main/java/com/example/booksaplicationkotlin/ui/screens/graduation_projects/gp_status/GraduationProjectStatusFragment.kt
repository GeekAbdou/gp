package com.example.readx.ui.screens.graduation_projects.gp_status

import androidx.fragment.app.viewModels
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentGraduationProjectStatusBinding
import com.example.readx.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class GraduationProjectStatusFragment :
    BaseFragment<FragmentGraduationProjectStatusBinding>() {
    override val layoutIdFragment = R.layout.fragment_graduation_project_status
    override val viewModel: GraduationProjectStatusViewModel by viewModels()
}