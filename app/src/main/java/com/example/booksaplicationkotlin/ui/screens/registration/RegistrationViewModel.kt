package com.example.readx.ui.screens.registration

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.network.IReadxService
import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val iReadxService: IReadxService
) : BaseViewModel<RegistrationUIState, RegistrationNavigationEvent>(
    RegistrationUIState(),
    Event()
) {

    fun signup() {
        val firstName = state.value.firstName
        val lastName = state.value.lastName
        val email = state.value.email
        val studentId = state.value.studentId.toInt()
        val password = state.value.password
        val passwordConfirmation = state.value.passwordConfirmation


        viewModelScope.launch {
            try {
                val response = iReadxService.registerUser(
                    firstName,
                    lastName,
                    email,
                    studentId,
                    password,
                    passwordConfirmation
                )
                if (response.isSuccessful) {
                    val signUpDTO = response.body()?.data
                    // Print or handle the loginDTO here
                    Log.d("SIGNUP_RESPONSE", "Sign up successful: $signUpDTO")
                    navToLogin()
                } else {
                    // Handle unsuccessful response here
                    Log.e("SIGNUP_ERROR", "Sign up failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                // Handle exceptions, e.g., show an error message
                Log.e("SIGNUP_ERROR", "Sign up failed: ${e.message}", e)
            }
        }

        Log.d(
            "NONI",
            "Sign up fun is here firstName$firstName, lastName$lastName\n" +
                    "    email $email, password $password, student_id $studentId",
        )
    }

    fun navToLogin() {
        _event.update { Event(RegistrationNavigationEvent.NavigateToLogin) }
    }

}



