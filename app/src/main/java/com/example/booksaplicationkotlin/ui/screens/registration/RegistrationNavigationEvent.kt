package com.example.readx.ui.screens.registration

sealed class RegistrationNavigationEvent {
    object NavigateToLogin : RegistrationNavigationEvent()
    data class NavigateToHome(val userId: Int) : RegistrationNavigationEvent()

}