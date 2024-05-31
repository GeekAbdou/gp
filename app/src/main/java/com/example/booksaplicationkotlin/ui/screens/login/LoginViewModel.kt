package com.example.readx.ui.screens.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.ReadxSharedPreferences
import com.example.booksaplicationkotlin.model.BaseResponse
import com.example.booksaplicationkotlin.network.IReadxService
import com.example.readx.models.LoginDTO
import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val iReadxService: IReadxService,
    private var readxSharedPreferences: ReadxSharedPreferences
) : BaseViewModel<LoginUiState, LoginNavigationEvent>(LoginUiState(), Event()) {

    fun login() {
        val email = state.value.email
        val password = state.value.password


        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true) }
                val response = iReadxService.loginUser(email, password)
                if (response.isSuccessful) {
                    val loginDTO = response.body()?.data
                    // Print or handle the loginDTO here
                    readxSharedPreferences.saveToken(loginDTO?.token ?: "")
                    Log.d(TAG, "Login successful: $response")
                    _state.update { it.copy(isLoading = false) }
                    navToHome()
                } else {
                    // Handle unsuccessful response here
                    Log.e(TAG, "Login failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                // Handle exceptions, e.g., show an error message
                Log.e(TAG, "Login failed: ${e.message}", e)
            }
        }

        Log.d(
            TAG, "login fun is here email $email, password $password "

        )
    }


    private fun onSuccess(result: Response<BaseResponse<LoginDTO>>) {
        result.let { response ->
            if (response.isSuccessful) {
                val loginDTO = response.body()?.data!!
                saveToken(loginDTO.token)
                navToHome()
                Log.d(TAG, "Login successful: $response")

            } else {
                // Handle unsuccessful response here
                Log.e(TAG, "Login failed: ${response.errorBody()?.string()}")
            }


        }
    }

    private fun navToHome() {
        Log.d(TAG, "navToHome: ")
        _event.update { Event(LoginNavigationEvent.NavigateToHome) }
    }

    private fun saveToken(token: String) {
        viewModelScope.launch {
            readxSharedPreferences.saveToken(token)
        }
    }

    private fun onError(e: Throwable) {
//        _state.update {
//            it.copy(isError = e.message.toString())
//        }
    }

    fun onRegisterNowClicked() {
        _event.update { Event(LoginNavigationEvent.NavigateToRegistration) }
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}
