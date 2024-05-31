package com.example.readx.ui.screens.login

sealed class LoginNavigationEvent {
    object NavigateToRegistration: LoginNavigationEvent()
    object NavigateToHome : LoginNavigationEvent()

}