package com.example.readx.ui.screens.login

data class LoginUiState(
    val isPasswordError: Boolean = false,
    val isLoading: Boolean = false,
    val isEmailError: Boolean = false,
    val errorMessage: String = "",
    var email: String = "",
    var password: String = "",


)
