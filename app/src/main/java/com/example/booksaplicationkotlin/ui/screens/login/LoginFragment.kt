package com.example.readx.ui.screens.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentLoginBinding
import com.example.readx.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment() :
    BaseFragment<FragmentLoginBinding>() {
    override val layoutIdFragment = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: LoginNavigationEvent) {
        val action = when (event) {
            is LoginNavigationEvent.NavigateToRegistration ->
                LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()

            is LoginNavigationEvent.NavigateToHome ->{
                Log.d(TAG, "onEvent: NavigateToHome")
                LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            }

        }
        findNavController().navigate(action)

    }

    companion object{
        const val TAG = "LoginFragment"
    }

}