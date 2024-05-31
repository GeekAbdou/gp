@file:OptIn(NavigationUiSaveStateControl::class)

package com.example.booksaplicationkotlin.ui.screens.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUiSaveStateControl
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentHomeBinding
import com.example.readx.ui.base.BaseFragment
import com.example.readx.ui.screens.home.HomeNavigationEvent
import com.example.readx.ui.screens.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()


    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: HomeNavigationEvent) {
        val action = when (event) {
            HomeNavigationEvent.NavigateToLogin ->
                HomeFragmentDirections.actionHomeFragmentToLoginFragment()
        }
        findNavController().navigate(action)

    }
}