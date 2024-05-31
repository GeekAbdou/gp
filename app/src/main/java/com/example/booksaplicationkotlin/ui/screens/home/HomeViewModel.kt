package com.example.readx.ui.screens.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.ReadxSharedPreferences
import com.example.booksaplicationkotlin.network.IReadxService
import com.example.booksaplicationkotlin.ui.screens.home.HomeUIState
import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    readxSharedPreferences: ReadxSharedPreferences,
    private val readXService: IReadxService,
) : BaseViewModel<HomeUIState, HomeNavigationEvent>(HomeUIState(), Event()) {

    init {
        val token = readxSharedPreferences.getToken()
        Log.d(TAG, "ddd token: $token")
        checkTokenValidation(token)
    }

    private fun checkTokenValidation(token: String?) {
        Log.d(TAG, "checkTokenValidation: ")
        if (token.isNullOrBlank()) {
            Log.d(TAG, "Token is null or blank, navigating to login")
            navToLogin()
        } else {
            viewModelScope.launch {
                try {
                    val response = readXService.getBooks("Bearer $token")

                    Log.d(TAG, "checkTokenValidation: response$response")
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null && responseBody.msg.isNullOrEmpty()) {
                            Log.d(TAG, "Token is valid, updating state to authorized")
                            _state.update { it.copy(isAuthorized = true) }
                            getHomeData("Bearer $token")
                            _state.update { it.copy(isLoading = false) }
                        } else {
                            Log.d(TAG, "Token is invalid, navigating to login")
                            navToLogin()
                        }
                    } else {
                        Log.e(TAG, "API Error: ${response.code()} - ${response.message()}")
                        navToLogin()
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Request failed", e)
                    navToLogin()
                }
            }
        }
    }

    private fun getHomeData(token: String) {
        Log.d(TAG, "getHomeData: token $token")
        getExams(token)
        getGradProjects(token)
        getBooks(token)
    }

    private fun getExams(token: String) {
        viewModelScope.launch {
            readXService.getExams(token)
            try {
                val response = readXService.getExams(token = token)

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val message = responseBody.msg
                        val data = responseBody.data
                        Log.d(TAG, "Message: $message, Data: $data")
                        _state.update { it.copy(exams = data!!) }
                    } else {
                        // Handle empty response body
                        Log.d(TAG, "Response body is null")
                    }
                } else {
                    // Handle API error
                    Log.e(TAG, "API Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e(TAG, "Request failed", e)
            }

        }
    }

    private fun getGradProjects(token: String) {
        viewModelScope.launch {
            readXService.getExams(token)
            try {
                val response = readXService.getGradProjects(token = token)

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val message = responseBody.msg
                        val data = responseBody.data
                        _state.update { it.copy(gradProjects = data!!) }
                        Log.d(TAG, "Message: $message, Data: $data")
                    } else {
                        // Handle empty response body
                        Log.d(TAG, "Response body is null")
                    }
                } else {
                    // Handle API error
                    Log.e(TAG, "API Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e(TAG, "Request failed", e)
            }

        }

    }

    private fun getBooks(token: String) {
        viewModelScope.launch {
            readXService.getExams(token)
            try {
                val response = readXService.getBooks(token = token)

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val message = responseBody.msg
                        val data = responseBody.data
                        _state.update { it.copy(books = data!!) }
                        Log.d(TAG, "Message: $message, Data: $data")
                    } else {
                        // Handle empty response body
                        Log.d(TAG, "Response body is null")
                    }
                } else {
                    // Handle API error
                    Log.e(TAG, "API Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e(TAG, "Request failed", e)
            }

        }

    }


    private fun navToLogin() {
        Log.d(TAG, "navToLogin: ")
        _event.update { Event(HomeNavigationEvent.NavigateToLogin) }

    }

    companion object {
        const val TAG = "HomeViewModel"
    }

}