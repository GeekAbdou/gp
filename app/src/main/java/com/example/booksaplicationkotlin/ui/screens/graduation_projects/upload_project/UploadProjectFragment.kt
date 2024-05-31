package com.example.readx.ui.screens.graduation_projects.upload_project

import androidx.fragment.app.viewModels
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentUploadProjectBinding
import com.example.readx.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UploadProjectFragment() :
    BaseFragment<FragmentUploadProjectBinding>() {
    override val layoutIdFragment = R.layout.fragment_upload_project
    override val viewModel: UploadProjectViewModel by viewModels()
}