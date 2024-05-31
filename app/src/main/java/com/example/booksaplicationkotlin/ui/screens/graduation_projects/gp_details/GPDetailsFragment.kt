package com.example.booksaplicationkotlin.ui.screens.graduation_projects.gp_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentGPDetailsBinding
import com.example.readx.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GPDetailsFragment : BaseFragment<FragmentGPDetailsBinding>() {
    override val layoutIdFragment= R.layout.fragment_g_p_details
    override val viewModel: GPDetailsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        binding.projectToolbar.setupWithNavController(navController)
    }
}