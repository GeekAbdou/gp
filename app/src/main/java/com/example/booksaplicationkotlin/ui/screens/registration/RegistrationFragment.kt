package com.example.readx.ui.screens.registration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentRegistrationBinding
import com.example.readx.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment() : BaseFragment<FragmentRegistrationBinding>() {
    override val layoutIdFragment = R.layout.fragment_registration
    override val viewModel: RegistrationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: RegistrationNavigationEvent) {
        val action = when (event) {
            is RegistrationNavigationEvent.NavigateToHome ->
                RegistrationFragmentDirections.actionRegistrationFragmentToHomeFragment()

            is RegistrationNavigationEvent.NavigateToLogin ->
                RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()

        }
        findNavController().navigate(action)

    }

}